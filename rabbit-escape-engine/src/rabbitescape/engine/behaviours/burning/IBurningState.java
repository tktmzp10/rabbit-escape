package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;

public interface IBurningState
{
    public State newState();

    public boolean behave( World world, Rabbit rabbit );
}
