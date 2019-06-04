package rabbitescape.engine.behaviours.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_ONTO_LOWER_LEFT;

public class FallingOntoLowerLeft implements IFallingState
{
    @Override
    public State newState()
    {
        return RABBIT_FALLING_ONTO_LOWER_LEFT;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
