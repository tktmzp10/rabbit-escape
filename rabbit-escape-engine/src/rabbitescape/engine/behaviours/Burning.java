package rabbitescape.engine.behaviours;

import rabbitescape.engine.Behaviour;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.burning.BurningNormal;
import rabbitescape.engine.behaviours.burning.BurningOnSlope;
import rabbitescape.engine.behaviours.burning.IBurningState;

public class Burning extends Behaviour
{
    private IBurningState burningState;

    public Burning()
    {
        this.burningState = new BurningNormal();
    }

    public void setBurningState(IBurningState burningState) {
        this.burningState = burningState;
    }

    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Rabbit rabbit, World world )
    {
        return world.fireAt( rabbit.x, rabbit.y );
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        State state = null;

        if (t.rabbit.onSlope)
        {
            setBurningState( new BurningOnSlope() );
        }

        if ( triggered )
        {
            state = burningState.newState();
        }

        return state;
    }

    @Override
    public boolean behave( World world, Rabbit rabbit, State state )
    {
        switch ( state )
        {
        case RABBIT_BURNING:
        case RABBIT_BURNING_ON_SLOPE:
        {
            world.changes.killRabbit( rabbit );
            return true;
        }
        default:
        {
            return false;
        }
        }
    }

    @Override
    public String toString()
    {
        return "Burning";
    }
}
