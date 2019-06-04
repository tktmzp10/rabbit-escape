package rabbitescape.engine.newstates.characterstates.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_DOWN_UP_LEFT_2;

public class BridgingDownUpLeft2 implements IBridgingState
{
    @Override
    public State newState()
    {
        return RABBIT_BRIDGING_DOWN_UP_LEFT_2;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
