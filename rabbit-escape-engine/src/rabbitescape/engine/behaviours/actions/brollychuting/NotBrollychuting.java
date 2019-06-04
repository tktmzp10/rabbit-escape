package rabbitescape.engine.behaviours.actions.brollychuting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.behaviours.actions.waiting.IWaitingState;
import rabbitescape.engine.things.Character;

public class NotBrollychuting implements IBrollychutingState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        return false;
    }
}
