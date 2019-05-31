package rabbitescape.engine.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.Behaviour;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;
import rabbitescape.engine.Rabbit;
import rabbitescape.engine.World;
import rabbitescape.engine.config.TapTimer;

public class OutOfBounds extends Behaviour
{
    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        return (
               character.x < 0
            || character.x >= world.size.width
            || character.y < 0
            || character.y >= world.size.height
        );
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    )
    {
        if ( triggered )
        {
            return RABBIT_OUT_OF_BOUNDS;
        }

        return null;
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        switch( state )
        {
            case RABBIT_OUT_OF_BOUNDS:
            {
                checkMars( world, character );
                world.changes.killRabbit( character );
                return true;
            }
            default:
            {
                return false;
            }
        }
    }

    /**
     * Test if mars mode has been triggered
     */
    private void checkMars( World world, Character character)
    {
        /* The character must leave the world at the correct coordinates,
         * the index count is likely to only be correct if this is the
         * first character out of the entrance, and it must be the correct
         * level.
         */
        if ( 12 == character.x && -1 == character.y &&
             world.getRabbitIndexCount() == 2 &&
             world.name.equals( "Ghost versus pie" ) )
        {
            TapTimer.setMars();
        }
    }

    @Override
    public String toString()
    {
        return "OutOfBounds";
    }
}
