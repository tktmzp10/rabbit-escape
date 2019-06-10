package rabbitescape.engine.newstates.environment_states.fire_states;

import static rabbitescape.engine.ChangeDescription.State.FIRE_A_RISE_LEFT;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.environment_states.FireStates;

public class FireARiseLeft extends FireStates {

    @Override
    public State getState() {
        return FIRE_A_RISE_LEFT;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    ) {
        return null;
    }
}
