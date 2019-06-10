package rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states;

import static rabbitescape.engine.ChangeDescription.State.FIRE_A_FALL_TO_RISE_RIGHT;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.environment_states.FireStates;

public class FireAFallToRiseRight extends FireStates {

    @Override
    public State getState() {
        return FIRE_A_FALL_TO_RISE_RIGHT;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    ) {
        return null;
    }
}
