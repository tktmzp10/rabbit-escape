package rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states;

import static rabbitescape.engine.ChangeDescription.State.FIRE_C_RISE_LEFT;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.environment_states.FireStates;

public class FireCRiseLeft extends FireStates {

    @Override
    public State getState() {
        return FIRE_C_RISE_LEFT;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    ) {
        return null;
    }
}
