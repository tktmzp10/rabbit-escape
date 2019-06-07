package rabbitescape.engine.newstates.item_states.block;

import rabbitescape.engine.ChangeDescription.State;

public class BlockOnSlop extends BlockItemState {

    @Override
    public State getState() {
        return State.TOKEN_BLOCK_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
