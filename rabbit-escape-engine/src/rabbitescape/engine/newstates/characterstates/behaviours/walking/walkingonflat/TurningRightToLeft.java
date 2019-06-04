package rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonflat;

import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Shape.BRIDGE_UP_LEFT;
import static rabbitescape.engine.Block.Shape.BRIDGE_UP_RIGHT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_RIGHT_TO_LEFT;
import static rabbitescape.engine.Direction.LEFT;

public class TurningRightToLeft implements IWalkingState
{
    @Override
    public State getState()
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
