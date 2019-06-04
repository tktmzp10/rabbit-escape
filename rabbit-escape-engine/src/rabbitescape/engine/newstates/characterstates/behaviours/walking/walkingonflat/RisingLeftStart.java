package rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonflat;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_RISING_LEFT_START;

public class RisingLeftStart implements IWalkingState
{
    @Override
    public State newState()
    {
        return RABBIT_RISING_LEFT_START;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        --character.x;
        character.onSlope = true;
        return true;
    }
}
