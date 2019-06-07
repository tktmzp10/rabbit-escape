package rabbitescape.engine.newstates.character_states.behaviours;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.character_states.behaviours.burning.*;

public class Burning extends CharacterBehaviourStates {

    private IBurningState burningState;

    public Burning() {
        setBurningState(new NotBurning());
    }

    public void setBurningState(IBurningState burningState) {
        this.burningState = burningState;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        return world.fireAt(character.x, character.y);
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (triggered) {
            if (t.character.onSlope) {
                setBurningState(new BurningOnSlope());
            } else {
                setBurningState(new BurningNormal());
            }
        }

        return burningState.getState();
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return burningState.behave(world, character);
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState) {
        return behave(world, character, state);
    }

    @Override
    public State getState() {
        return burningState.getState();
    }
}
