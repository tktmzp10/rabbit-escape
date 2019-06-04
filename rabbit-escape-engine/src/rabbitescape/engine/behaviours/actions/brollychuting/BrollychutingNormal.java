package rabbitescape.engine.behaviours.actions.brollychuting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.actions.waiting.IWaitingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BROLLYCHUTING;

public class BrollychutingNormal implements IBrollychutingState
{
    @Override
    public State newState()
    {
        return RABBIT_BROLLYCHUTING;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
