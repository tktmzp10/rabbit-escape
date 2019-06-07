package rabbitescape.engine.newstates.character_states.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.things.items.ItemType.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterActionStates;
import rabbitescape.engine.newstates.character_states.actions.digging.*;
import rabbitescape.engine.things.Character;

public class Digging extends CharacterActionStates {

    private IDiggingState diggingState;
    public int stepsOfDigging;

    public Digging() {
        setDiggingState(new NotDigging());
    }

    public void setDiggingState(IDiggingState diggingState) {
        this.diggingState = diggingState;
    }

    @Override
    public void cancel() {
        stepsOfDigging = 0;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);
        return t.pickUpToken(dig);
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (!triggered && stepsOfDigging == 0) {
            setDiggingState(new NotDigging());
            return diggingState.newState();
        }

        t.character.possiblyUndoSlopeBashHop(t.world);

        if (t.character.state == RABBIT_DIGGING) {
            stepsOfDigging = 1;
            setDiggingState(new Digging2());
            return diggingState.newState();
        }

        if (triggered || stepsOfDigging > 0) {
            if (t.character.onSlope && t.blockHere() != null) {
                stepsOfDigging = 1;
                setDiggingState(new DiggingOnSlope());
            } else if (t.blockBelow() != null) {
                if (t.blockBelow().material == Block.Material.METAL) {
                    stepsOfDigging = 0;
                    setDiggingState(new DiggingUselessly());
                } else {
                    stepsOfDigging = 2;
                    setDiggingState(new DiggingNormal());
                }
            } else {
                --stepsOfDigging;
                setDiggingState(new NotDigging());
            }
        } else {
            --stepsOfDigging;
            setDiggingState(new NotDigging());
        }

        return diggingState.newState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return diggingState.behave(world, character);
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfGtZero(
            saveState, "Digging.stepsOfDigging", stepsOfDigging);
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        stepsOfDigging = BehaviourState.restoreFromState(
            saveState, "Digging.stepsOfDigging", stepsOfDigging);
    }

    public static boolean isDigging(State state) {
        switch (state) {
            case RABBIT_DIGGING:
            case RABBIT_DIGGING_2:
            case RABBIT_DIGGING_ON_SLOPE:
            case RABBIT_DIGGING_USELESSLY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public State getState() {
        return null;
    }
}
