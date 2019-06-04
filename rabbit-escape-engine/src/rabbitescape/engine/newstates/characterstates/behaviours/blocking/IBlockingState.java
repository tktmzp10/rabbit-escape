package rabbitescape.engine.newstates.characterstates.behaviours.blocking;

import rabbitescape.engine.ChangeDescription.State;

public interface IBlockingState
{
    public State newState();

    public boolean behave();
}
