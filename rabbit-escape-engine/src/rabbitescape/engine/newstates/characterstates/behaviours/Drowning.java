package rabbitescape.engine.newstates.characterstates.behaviours;

import static rabbitescape.engine.CellularDirection.DOWN;
import static rabbitescape.engine.CellularDirection.UP;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.newstates.characterstates.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.characterstates.behaviours.drowning.DrowningNormal;
import rabbitescape.engine.newstates.characterstates.behaviours.drowning.IDrowningState;
import rabbitescape.engine.newstates.characterstates.behaviours.drowning.NotDrowning;
import rabbitescape.engine.things.characters.Rabbot;
import rabbitescape.engine.things.environment.WaterRegion;

public class Drowning extends CharacterBehaviourStates
{
    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        if ( character instanceof Rabbot )
        {
            return false;  // Rabbots don't drown
        }

        int yCoordinate = character.y;
        CellularDirection directionToCheck = UP;
        if ( character.onSlope )
        {
            // The character's head is at the bottom of the cell above.
            yCoordinate = character.y - 1;
            directionToCheck = DOWN;
        }
        // TODO Find out why the character's y coordinate is allowed to be
        // larger than the size of the world (see solution for easy-12).
        if ( yCoordinate < 0 || yCoordinate >= world.size.height )
        {
            return false;
        }
        for ( WaterRegion waterRegion :
              world.waterTable.getItemsAt( character.x, yCoordinate ) )
        {
            if ( waterRegion.isConnected( directionToCheck ) )
            {
                return ( waterRegion.getContents() >= waterRegion.capacity );
            }
        }
        return false;
    }

    @Override
    public State newState(
        BehaviourTools t,
        boolean triggered )
    {
        return ( triggered ? State.RABBIT_DROWNING : null );
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        switch ( state )
        {
            case RABBIT_DROWNING:
                world.changes.killRabbit( character );
                return true;
            default:
                return false;
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
