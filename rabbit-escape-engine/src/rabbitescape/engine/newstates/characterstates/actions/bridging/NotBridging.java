package rabbitescape.engine.newstates.characterstates.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.actions.Bridging.*;
import rabbitescape.engine.things.Character;

public class NotBridging implements IBridgingState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character, BridgeType bridgeType
    )
    {
        return false;
    }
}
