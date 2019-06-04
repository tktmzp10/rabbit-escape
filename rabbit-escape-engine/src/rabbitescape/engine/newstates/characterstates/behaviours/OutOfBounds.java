package rabbitescape.engine.newstates.characterstates.behaviours;

import rabbitescape.engine.NewStates;
import rabbitescape.engine.config.TapTimer;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.characterstates.CharacterBehaviourStates;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.behaviours.outofbounds.IOutOfBoundsState;
import rabbitescape.engine.newstates.characterstates.behaviours.outofbounds.NotOutOfBounds;
import rabbitescape.engine.newstates.characterstates.behaviours.outofbounds.OutOfBoundsNormal;

public class OutOfBounds extends CharacterBehaviourStates
{
    private IOutOfBoundsState outOfBoundsState;

    public OutOfBounds()
    {
        this.outOfBoundsState = new NotOutOfBounds();
    }

    public void setOutOfBoundsState( IOutOfBoundsState outOfBoundsState )
    {
        this.outOfBoundsState = outOfBoundsState;
    }

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
    public State getState()
    {
        return null;
    }

    @Override
    public State newState(
        BehaviourTools t, boolean triggered
    )
    {
        if ( triggered )
        {
            setOutOfBoundsState( new OutOfBoundsNormal() );
        }

        return outOfBoundsState.getState();
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

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState
    )
    {
        return behave( world, character, state );
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
}
