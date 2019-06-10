package rabbitescape.engine.new_states.character_states.actions.blocking;

import rabbitescape.engine.ChangeDescription.State;

public interface IBlockingState {

    public State getState();

    public boolean behave();
}
