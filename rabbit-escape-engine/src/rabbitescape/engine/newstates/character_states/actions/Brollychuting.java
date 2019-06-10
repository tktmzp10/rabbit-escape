package rabbitescape.engine.newstates.character_states.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.things.items.ItemType.brolly;

import java.util.Map;

import rabbitescape.engine.BehaviourState;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterActionStates;
import rabbitescape.engine.newstates.character_states.actions.brollychuting.BrollychutingNormal;
import rabbitescape.engine.newstates.character_states.actions.brollychuting.IBrollychutingState;
import rabbitescape.engine.newstates.character_states.actions.brollychuting.NotBrollychuting;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public class Brollychuting extends CharacterActionStates {

    private IBrollychutingState brollychutingState;
    boolean hasAbility = false;
    private final Climbing climbing;
    private final Digging digging;

    public Brollychuting(Climbing climbing, Digging digging) {
        setBrollychutingState(new NotBrollychuting());
        this.climbing = climbing;
        this.digging = digging;
    }

    public void setBrollychutingState(IBrollychutingState brollychutingState) {
        this.brollychutingState = brollychutingState;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        hasAbility = triggered;
        Block below = t.blockBelow();

        if (newStateNotBrollychuting(t, below)) {
            return brollychutingState.newState();
        }

        if (below != null) {
            if (t.isUpSlope(below)) {
                return t.rl(
                    RABBIT_FALLING_1_ONTO_RISE_RIGHT,
                    RABBIT_FALLING_1_ONTO_RISE_LEFT
                );
            } else // Must be a slope in the opposite direction
            {
                return t.rl(
                    RABBIT_FALLING_1_ONTO_LOWER_RIGHT,
                    RABBIT_FALLING_1_ONTO_LOWER_LEFT
                );
            }
        }
        setBrollychutingState(new BrollychutingNormal());

        return brollychutingState.newState();
    }

    private boolean newStateNotBrollychuting(BehaviourTools t, Block below) {
        if (!hasAbility || climbing.abilityActive || t.isFlat(below) || (t.character.onSlope && !t.blockHereJustRemoved())) {
            setBrollychutingState(new NotBrollychuting());
            return true;
        }
        return false;
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return brollychutingState.behave(world, character);
    }

    public boolean hasBrolly() {
        return hasAbility;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);

        if (!hasAbility && t.pickUpItem(brolly, true)) {
            return true;
        }

        if (!hasAbility) {
            return false;
        }

        if (climbing.abilityActive || digging.stepsOfDigging > 2) {
            return false;
        }

        if (t.isFlat(t.blockBelow())) {
            return false;
        }

        if (
            character.onSlope
                && !t.blockHereJustRemoved()
        ) {
            return false;
        }

        return true;
    }

    @Override
    public void cancel() {
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfTrue(
            saveState, "Brollychuting.hasAbility", hasAbility
        );

    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        hasAbility = BehaviourState.restoreFromState(
            saveState, "Brollychuting.hasAbility", hasAbility
        );

    }

    @Override
    public State getState() {
        return null;
    }
}
