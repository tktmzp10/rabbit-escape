package rabbitescape.engine.newstates.character_states.actions.blocking;

import rabbitescape.engine.ChangeDescription.State;

public class NotBlocking implements IBlockingState {

    @Override
    public State getState() {
        return null;
    }

    @Override
    public boolean behave() {
        return false;
    }
}
