package rabbitescape.engine.newstates.characterstates.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.actions.Bridging.*;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_UP_RIGHT_2;

public class BridgingUpRight2 implements IBridgingState
{
    @Override
    public State newState()
    {
        return RABBIT_BRIDGING_UP_RIGHT_2;
    }

    @Override
    public boolean behave(
        World world, Character character, BridgeType bridgeType
    )
    {
        character.onSlope = true;
        bridgeType = BridgeType.UP;
        return true;
    }
}
