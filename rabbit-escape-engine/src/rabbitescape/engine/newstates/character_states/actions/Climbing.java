package rabbitescape.engine.newstates.character_states.actions;

import static rabbitescape.engine.things.items.ItemType.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterActionStates;
import rabbitescape.engine.newstates.character_states.actions.climbing.IClimbingState;
import rabbitescape.engine.newstates.character_states.actions.climbing.NotClimbing;
import rabbitescape.engine.things.Character;

public class Climbing extends CharacterActionStates {

    private IClimbingState climbingState;
    boolean hasAbility = false;
    public boolean abilityActive = false;

    public Climbing() {
        setClimbingState(new NotClimbing());
    }

    public void setClimbingState(IClimbingState climbingState) {
        this.climbingState = climbingState;
    }

    @Override
    public void cancel() {
        abilityActive = false;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        BehaviourTools t = new BehaviourTools(character, world);

        return !hasAbility && t.pickUpItem(climb, true);
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            hasAbility = true;
        }

        if (!hasAbility) {
            setClimbingState(new NotClimbing());
            return null;
        }

        climbingState = climbingState.newState(t, this);

        return climbingState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        BehaviourTools t = new BehaviourTools(character, world);

        if (t.rabbitIsClimbing()) { // Can't be both on a wall and on a slope.
            character.onSlope = false;
        }

        return climbingState.behave(world, character, this);
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfTrue(
            saveState, "Climbing.hasAbility", hasAbility
        );

        BehaviourState.addToStateIfTrue(
            saveState, "Climbing.abilityActive", abilityActive
        );
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        hasAbility = BehaviourState.restoreFromState(
            saveState, "Climbing.hasAbility", hasAbility
        );

        abilityActive = BehaviourState.restoreFromState(
            saveState, "Climbing.abilityActive", abilityActive
        );
    }

    @Override
    public State getState() {
        return null;
    }
}
