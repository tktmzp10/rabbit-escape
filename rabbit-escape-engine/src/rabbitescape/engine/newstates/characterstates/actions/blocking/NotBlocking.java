package rabbitescape.engine.newstates.characterstates.actions.blocking;

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
