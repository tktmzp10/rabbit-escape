package rabbitescape.engine.newstates.character_states.actions.blocking;

import rabbitescape.engine.ChangeDescription.State;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BLOCKING_RISE_RIGHT;

public class BlockingRiseRight implements IBlockingState {

    @Override
    public State getState() {
        return RABBIT_BLOCKING_RISE_RIGHT;
    }

    @Override
    public boolean behave() {
        return true;
    }
}
