package rabbitescape.engine.behaviours.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IFallingState
{
    public State newState();

    public boolean behave( World world, Character character );
}