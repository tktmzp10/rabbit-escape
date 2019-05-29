package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.Chars;

public class NotBurning implements IBurningState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Rabbit rabbit
    )
    {
        return false;
    }
}
