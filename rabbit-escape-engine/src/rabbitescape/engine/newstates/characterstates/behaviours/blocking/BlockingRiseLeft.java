package rabbitescape.engine.newstates.characterstates.behaviours.blocking;

import rabbitescape.engine.ChangeDescription.State;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BLOCKING_RISE_LEFT;

public class BlockingRiseLeft implements IBlockingState
{
    @Override
    public State getState()
    {
        return RABBIT_BLOCKING_RISE_LEFT;
    }

    @Override
    public boolean behave()
    {
        return true;
    }
}
