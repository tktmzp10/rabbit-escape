package rabbitescape.engine.newstates.characterstates.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.newstates.characterstates.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.characterstates.behaviours.exiting.*;
import rabbitescape.engine.things.characters.Rabbot;
import rabbitescape.engine.things.environment.Exit;

public class Exiting extends CharacterBehaviourStates
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
    public State getState()
    {
        return null;
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
    public boolean behave(
        World world, Character character, State state, NewStates newState
    )
    {
        return behave( world, character, state );
    }
}
