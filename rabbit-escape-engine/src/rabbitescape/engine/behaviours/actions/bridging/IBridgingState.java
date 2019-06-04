package rabbitescape.engine.behaviours.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IBridgingState
{
    public State newState();

    public boolean behave( World world, Character character );
}