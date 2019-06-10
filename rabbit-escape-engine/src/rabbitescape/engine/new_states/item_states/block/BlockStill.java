package rabbitescape.engine.new_states.item_states.block;

import rabbitescape.engine.ChangeDescription.State;

public class BlockStill extends BlockItemState {

    @Override
    public State getState() {
        return State.TOKEN_BLOCK_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
