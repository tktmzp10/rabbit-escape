package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BURNING;

public class BurningNormal implements IBurningState
{
    @Override
    public State newState()
    {
        return RABBIT_BURNING;
    }

    @Override
    public boolean behave( World world, Rabbit rabbit )
    {
        world.changes.killRabbit( rabbit );
        return true;
    }


}
