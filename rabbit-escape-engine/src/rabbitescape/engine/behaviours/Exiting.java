package rabbitescape.engine.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;

public class Exiting extends Behaviour
{
    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        if ( character instanceof Rabbot)
        {
            return false;  // Rabbots ignore exits
        }

        for ( Thing thing : world.things )
        {
            if (
                   ( thing instanceof Exit )
                && ( thing.x == character.x && thing.y == character.y )
            )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( triggered )
        {
            if ( t.character.state == RABBIT_CLIMBING_LEFT_CONTINUE_2 )
            {
                return RABBIT_ENTERING_EXIT_CLIMBING_LEFT;
            }
            if ( t.character.state == RABBIT_CLIMBING_RIGHT_CONTINUE_2 )
            {
                return RABBIT_ENTERING_EXIT_CLIMBING_RIGHT;
            }
            return RABBIT_ENTERING_EXIT;
        }
        return null;
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        if (
               state == RABBIT_ENTERING_EXIT
            || state == RABBIT_ENTERING_EXIT_CLIMBING_RIGHT
            || state == RABBIT_ENTERING_EXIT_CLIMBING_LEFT
           )
        {
            world.changes.saveRabbit( character );
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "Exiting";
    }
}
