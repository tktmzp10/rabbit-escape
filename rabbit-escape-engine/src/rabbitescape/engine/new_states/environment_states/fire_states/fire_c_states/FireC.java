package rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states;

import static rabbitescape.engine.ChangeDescription.State.FIRE_C;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.environment_states.FireStates;
import rabbitescape.engine.things.environment.Fire;

public class FireC extends FireStates {

    @Override
    public State getState() {
        return FIRE_C;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    ) {
        return null;
    }

    @Override
    public void step(World world, Fire fire) {

    }
}
