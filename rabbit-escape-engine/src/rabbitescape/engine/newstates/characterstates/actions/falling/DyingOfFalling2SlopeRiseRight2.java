package rabbitescape.engine.newstates.characterstates.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT_2;

public class DyingOfFalling2SlopeRiseRight2 implements IFallingState
{
    @Override
    public State newState()
    {
        return RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT_2;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
