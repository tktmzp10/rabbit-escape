package rabbitescape.engine.newstates.characterstates.behaviours.outofbounds;

import rabbitescape.engine.ChangeDescription;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public class NotOutOfBounds implements IOutOfBoundsState
{
    @Override
    public ChangeDescription.State getState()
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