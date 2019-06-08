package rabbitescape.engine.newstates.item_states.block;

import rabbitescape.engine.ChangeDescription.State;

public class BlockFalling extends BlockItemState {

    @Override
    public State getState() {
        return State.TOKEN_BLOCK_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
