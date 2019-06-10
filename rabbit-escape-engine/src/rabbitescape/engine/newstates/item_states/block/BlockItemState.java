package rabbitescape.engine.newstates.item_states.block;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class BlockItemState extends ItemState {

    @Override
    public ItemState newState() {
        ItemState newState;

        if (isOnSlope()) {
            newState = new BlockOnSlope();
        } else if (!isMoving()) {
            newState = new BlockStill();
        } else if (isSlopeBelow()) {
            newState = new BlockFallToSlope();
        } else {
            newState = new BlockFalling();
        }

        return newState;
    }

}
