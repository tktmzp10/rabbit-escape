package rabbitescape.engine.behaviours;

import static rabbitescape.engine.CellularDirection.DOWN;
import static rabbitescape.engine.CellularDirection.UP;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;

public class Drowning extends Behaviour
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
}
