package rabbitescape.engine.newstates.characterstates.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.things.items.ItemType.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.characterstates.CharacterActionStates;
import rabbitescape.engine.newstates.characterstates.actions.blocking.*;
import rabbitescape.engine.things.Character;

public class Blocking extends CharacterActionStates {

    private IBlockingState blockingState;
    public boolean abilityActive = false;

    public Blocking() {
        this.blockingState = new NotBlocking();
    }

    public void setBlockingState(IBlockingState blockingState) {
        this.blockingState = blockingState;
    }

    @Override
    public void cancel() {
        abilityActive = false;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);
        return t.pickUpToken(block);
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (abilityActive || triggered) {
            t.character.possiblyUndoSlopeBashHop(t.world);
            abilityActive = true;
            Block here = t.blockHere();

            if (BehaviourTools.isRightRiseSlope(here)) {
                setBlockingState(new BlockingRiseRight());
            } else if (BehaviourTools.isLeftRiseSlope(here)) {
                setBlockingState(new BlockingRiseLeft());
            } else {
                setBlockingState(new BlockingNormal());
            }
        } else {
            setBlockingState(new NotBlocking());
        }

        return blockingState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return isBlocking(state);
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfTrue(
            saveState, "Blocking.abilityActive", abilityActive
        );
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        abilityActive = BehaviourState.restoreFromState(
            saveState, "Blocking.abilityActive", abilityActive
        );
    }

    public static boolean blockerAt(World world, int nextX, int nextY) {
        Character[] characters = world.getCharactersAt(nextX, nextY);
        for (Character r : characters) {
            if (isBlocking(r.state)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlocking(State s) {
        switch (s) {
            case RABBIT_BLOCKING:
            case RABBIT_BLOCKING_RISE_RIGHT:
            case RABBIT_BLOCKING_RISE_LEFT:
                return true;
            default:
                return false;
        }
    }
}
