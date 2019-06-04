package rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonupslope;

import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Shape.BRIDGE_UP_LEFT;
import static rabbitescape.engine.Block.Shape.BRIDGE_UP_RIGHT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_LEFT_TO_RIGHT_RISING;
import static rabbitescape.engine.Direction.RIGHT;

public class TurningLeftToRightRising implements IWalkingState
{
    @Override
    public State getState()
    {
        return RABBIT_TURNING_LEFT_TO_RIGHT_RISING;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
