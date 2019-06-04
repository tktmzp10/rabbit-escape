package rabbitescape.engine.behaviours.actions.waiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.actions.digging.IDiggingState;
import rabbitescape.engine.things.Character;

public class NotWaiting implements IWaitingState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
