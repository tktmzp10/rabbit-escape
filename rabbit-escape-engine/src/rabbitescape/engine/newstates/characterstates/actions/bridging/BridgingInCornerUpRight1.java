package rabbitescape.engine.newstates.characterstates.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1;

public class BridgingInCornerUpRight1 implements IBridgingState
{
    @Override
    public State newState()
    {
        return RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
