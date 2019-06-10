package rabbitescape.engine.new_states.environment_states.fire_states;

import static rabbitescape.engine.ChangeDescription.State.FIRE_EXTINGUISHING;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.new_states.environment_states.FireStates;

public class FireExtinguishing extends FireStates {

    @Override
    public State getState() {
        return FIRE_EXTINGUISHING;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    ) {
        return null;
    }
}
