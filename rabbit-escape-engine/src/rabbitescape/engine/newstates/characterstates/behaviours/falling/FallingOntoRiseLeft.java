package rabbitescape.engine.newstates.characterstates.behaviours.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_ONTO_RISE_LEFT;

public class FallingOntoRiseLeft implements IFallingState
{
    @Override
    public State newState()
    {
        return RABBIT_FALLING_ONTO_RISE_LEFT;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
