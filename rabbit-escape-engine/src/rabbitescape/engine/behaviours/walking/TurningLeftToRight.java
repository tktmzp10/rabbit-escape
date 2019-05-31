package rabbitescape.engine.behaviours.walking;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_LEFT_TO_RIGHT;

public class TurningLeftToRight implements IWalkingState
{
    @Override
    public State newState()
    {
        return RABBIT_TURNING_LEFT_TO_RIGHT;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
