package rabbitescape.engine.behaviours.states.outofbounds;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;
import rabbitescape.engine.World;

public interface IOutOfBoundsState
{
    public State newState();

    public boolean behave( World world, Character character );
}
