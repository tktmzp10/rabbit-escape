package rabbitescape.engine.new_states.environment_states;

import rabbitescape.engine.World;
import rabbitescape.engine.new_states.EnvironmentStates;
import rabbitescape.engine.things.environment.Fire;

public abstract class FireStates extends EnvironmentStates {

    public abstract void step(World world, Fire fire);
}
