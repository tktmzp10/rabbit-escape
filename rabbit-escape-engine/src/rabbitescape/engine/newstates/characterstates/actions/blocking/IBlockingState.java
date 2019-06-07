package rabbitescape.engine.newstates.characterstates.actions.blocking;

import rabbitescape.engine.ChangeDescription.State;

public interface IBlockingState {

    public State getState();

    public boolean behave();
}
