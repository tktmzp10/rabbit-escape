package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.Chars;

public interface IBurningState
{
    public State newState();

    public boolean behave( World world, Rabbit rabbit );
}
