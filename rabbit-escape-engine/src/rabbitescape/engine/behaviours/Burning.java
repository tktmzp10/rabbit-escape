package rabbitescape.engine.behaviours;

import rabbitescape.engine.Behaviour;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.burning.BurningNormal;
import rabbitescape.engine.behaviours.burning.BurningOnSlope;
import rabbitescape.engine.behaviours.burning.IBurningState;
import rabbitescape.engine.behaviours.burning.NotBurning;

public class Burning extends Behaviour
{
    private IBurningState burningState;

    public Burning()
    {
        this.burningState = new NotBurning();
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
        if ( triggered ) {
            setBurningState( new BurningNormal() );

            if (t.rabbit.onSlope)
            {
                setBurningState( new BurningOnSlope() );
            }
        }

        return burningState.newState();
    }

    @Override
    public boolean behave( World world, Rabbit rabbit, State state )
    {
        return burningState.behave( world, rabbit );
    }

    @Override
    public String toString()
    {
        return "Burning";
    }
}
