package rabbitescape.engine.newstates.characterstates.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.newstates.characterstates.behaviours.exiting.*;
import rabbitescape.engine.things.characters.Rabbot;
import rabbitescape.engine.things.environment.Exit;

public class Exiting extends CharacterStates
{
    private IExitingState exitingState;

    public Exiting()
    {
        this.exitingState = new NotExiting();
    }

    public void setExitingState( IExitingState exitingState )
    {
        this.exitingState = exitingState;
    }

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
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( triggered )
        {
            if ( t.character.state == RABBIT_CLIMBING_LEFT_CONTINUE_2 )
            {
                setExitingState( new EnteringExitClimbingLeft() );
            } else if ( t.character.state == RABBIT_CLIMBING_RIGHT_CONTINUE_2 )
            {
                setExitingState( new EnteringExitClimbingRight() );
            } else {
                setExitingState( new EnteringExit() );
            }
        }

        return exitingState.newState();
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        return exitingState.behave( world, character );
    }

    @Override
    public String toString()
    {
        return "Exiting";
    }
}
