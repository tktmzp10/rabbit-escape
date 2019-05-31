package rabbitescape.engine.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Token.Type.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;

public class Blocking extends Behaviour
{
    public boolean abilityActive = false;

    @Override
    public void cancel()
    {
        abilityActive = false;
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        BehaviourTools t = new BehaviourTools( character, world );
        return t.pickUpToken( block );
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( abilityActive || triggered )
        {
            t.character.possiblyUndoSlopeBashHop( t.world );
            abilityActive = true;
            Block here = t.blockHere();
            if( BehaviourTools.isRightRiseSlope( here ) )
            {
                return RABBIT_BLOCKING_RISE_RIGHT;
            }
            else if ( BehaviourTools.isLeftRiseSlope( here ) )
            {
                return RABBIT_BLOCKING_RISE_LEFT;
            }
            else
            {
                return RABBIT_BLOCKING;
            }
        }

        return null;
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        return isBlocking( state );
    }

    @Override
    public void saveState( Map<String, String> saveState )
    {
        BehaviourState.addToStateIfTrue(
            saveState, "Blocking.abilityActive", abilityActive
        );
    }

    @Override
    public void restoreFromState( Map<String, String> saveState )
    {
        abilityActive = BehaviourState.restoreFromState(
            saveState, "Blocking.abilityActive", abilityActive
        );
    }

    public static boolean blockerAt( World world, int nextX, int nextY )
    {
        Character[] characters = world.getCharactersAt( nextX, nextY );
        for ( Character r : characters )
        {
            if ( isBlocking( r.state ) )
            {
                return true;
            }
        }
        return false;
    }

    static boolean isBlocking( State s )
    {
        switch ( s ) {
        case RABBIT_BLOCKING:
        case RABBIT_BLOCKING_RISE_RIGHT:
        case RABBIT_BLOCKING_RISE_LEFT:
            return true;
        default:
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "Bashing";
    }
}
