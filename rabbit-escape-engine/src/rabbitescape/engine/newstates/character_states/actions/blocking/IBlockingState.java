package rabbitescape.engine.newstates.character_states.actions.blocking;

import rabbitescape.engine.ChangeDescription.State;

public interface IBlockingState {

    public State getState();

    public boolean behave();
}
