package rabbitescape.engine.behaviours.walking;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_RIGHT_TO_LEFT;

public class TurningRightToLeft implements IWalkingState
{
    @Override
    public State newState()
    {
        return RABBIT_TURNING_RIGHT_TO_LEFT;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
