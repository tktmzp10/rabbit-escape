package rabbitescape.engine.newstates.item_states.block;

import rabbitescape.engine.ChangeDescription.State;

public class BlockFallToSlope extends BlockItemState {

    @Override
    public State getState() {
        return State.TOKEN_BLOCK_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
