package rabbitescape.engine.newstates.characterstates.behaviours.outofbounds;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;
import rabbitescape.engine.config.TapTimer;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_OUT_OF_BOUNDS;

public class OutOfBoundsNormal implements IOutOfBoundsState
{
    @Override
    public State getState()
    {
        return RABBIT_OUT_OF_BOUNDS;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
