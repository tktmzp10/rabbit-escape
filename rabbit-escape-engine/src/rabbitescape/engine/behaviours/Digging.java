package rabbitescape.engine.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Token.Type.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;

public class Digging extends Behaviour
{
    int stepsOfDigging;

    @Override
    public void cancel()
    {
        stepsOfDigging = 0;
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        BehaviourTools t = new BehaviourTools( character, world );
        return t.pickUpToken( dig );
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( !triggered && stepsOfDigging == 0 )
        {
            return null;
        }

        t.character.possiblyUndoSlopeBashHop( t.world );

        if ( t.character.state == RABBIT_DIGGING )
        {
            stepsOfDigging = 1;
            return RABBIT_DIGGING_2;
        }

        if (
               triggered
            || stepsOfDigging > 0
        )
        {
            if ( t.character.onSlope && t.blockHere() != null )
            {
                stepsOfDigging = 1;
                return RABBIT_DIGGING_ON_SLOPE;
            }
            else if ( t.blockBelow() != null )
            {
                if ( t.blockBelow().material == Block.Material.METAL )
                {
                    stepsOfDigging = 0;
                    return RABBIT_DIGGING_USELESSLY;
                }
                else
                {
                stepsOfDigging = 2;
                return RABBIT_DIGGING;
                }
            }
        }

        --stepsOfDigging;
        return null;
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        switch ( state )
        {
            case RABBIT_DIGGING:
            {
                world.changes.removeBlockAt( character.x, character.y + 1 );
                ++character.y;
                return true;
            }
            case RABBIT_DIGGING_ON_SLOPE:
            {
                world.changes.removeBlockAt( character.x, character.y );
                character.onSlope = false;
                return true;
            }
            case RABBIT_DIGGING_2:
            case RABBIT_DIGGING_USELESSLY:
            {
                return true;
            }
            default:
            {
                return false;
            }
        }
    }

    @Override
    public void saveState( Map<String, String> saveState )
    {
        BehaviourState.addToStateIfGtZero(
            saveState, "Digging.stepsOfDigging", stepsOfDigging );
    }

    @Override
    public void restoreFromState( Map<String, String> saveState )
    {
        stepsOfDigging = BehaviourState.restoreFromState(
            saveState, "Digging.stepsOfDigging", stepsOfDigging );
    }

    public static boolean isDigging( State state )
    {
        switch ( state )
        {
            case RABBIT_DIGGING:
            case RABBIT_DIGGING_2:
            case RABBIT_DIGGING_ON_SLOPE:
            case RABBIT_DIGGING_USELESSLY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString()
    {
        return "Digging";
    }
}
