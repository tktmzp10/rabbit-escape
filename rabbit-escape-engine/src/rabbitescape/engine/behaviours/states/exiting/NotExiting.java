package rabbitescape.engine.behaviours.states.exiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Character;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.states.drowning.IDrowningState;

public class NotExiting implements IExitingState
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
