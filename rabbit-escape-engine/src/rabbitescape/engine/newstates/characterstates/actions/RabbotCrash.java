package rabbitescape.engine.newstates.characterstates.actions;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.newstates.characterstates.CharacterActionStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;
import rabbitescape.engine.things.characters.Rabbot;

public class RabbotCrash extends CharacterActionStates
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
            for ( Character otherCharacter : world.rabbits )
            {
                if ( otherCharacter instanceof Rabbit &&
                    otherCharacter.x == character.x &&
                    otherCharacter.y == character.y
                )
                {
                    world.changes.killRabbit( otherCharacter );
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( triggered )
        {
            return State.RABBIT_CRASHING;
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        if ( state == State.RABBIT_CRASHING )
        {
            world.changes.killRabbit( character );
            return true;
        }

        return false;
    }

    @Override
    public State getState()
    {
        return null;
    }
}