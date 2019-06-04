package rabbitescape.engine.behaviours.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_LEFT_1;

public class BridgingLeft1 implements IBridgingState
{
    @Override
    public State newState()
    {
        return RABBIT_BRIDGING_LEFT_1;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
