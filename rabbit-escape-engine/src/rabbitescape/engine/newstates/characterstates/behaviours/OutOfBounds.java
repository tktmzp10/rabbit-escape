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

import static rabbitescape.engine.ChangeDescription.State.RABBIT_OUT_OF_BOUNDS;

public class OutOfBounds extends CharacterBehaviourStates
{
    private IOutOfBoundsState outOfBoundsState;

    public OutOfBounds()
    {
        setOutOfBoundsState( new NotOutOfBounds() );
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
        return outOfBoundsState.behave( world, character );
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState
    )
    {
        return behave( world, character, state );
    }
}
