package rabbitescape.engine.newstates.characterstates.behaviours;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.characterstates.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.characterstates.behaviours.burning.IBurningState;
import rabbitescape.engine.newstates.characterstates.behaviours.burning.NotBurning;

import static rabbitescape.engine.ChangeDescription.State.*;

public class Burning extends CharacterBehaviourStates
{
    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        return world.fireAt( character.x, character.y );
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( triggered )
        {
            if ( t.character.onSlope )
            {
                return RABBIT_BURNING_ON_SLOPE;
            }
            else
            {
                return RABBIT_BURNING;
            }
        }

        return null;
    }

    @Override
    public boolean behave(
        World world, Character character, State state
    )
    {
        switch ( state )
        {
            case RABBIT_BURNING:
            case RABBIT_BURNING_ON_SLOPE:
            {
                world.changes.killRabbit( character );
                return true;
            }
            default:
            {
                return false;
            }
        }
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState
    )
    {
        return behave( world, character, state );
    }

    @Override
    public State getState()
    {
        return null;
    }
}
