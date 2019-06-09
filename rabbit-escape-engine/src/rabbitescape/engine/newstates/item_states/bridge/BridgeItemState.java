package rabbitescape.engine.newstates.item_states.bridge;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class BridgeItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new BridgeOnSlope();
        } else if (!isMoving) {
            newState = new BridgeStill();
        } else if (isSlopeBelow) {
            newState = new BridgeFallToSlope();
        } else {
            newState = new BridgeFalling();
        }

        return newState;
    }

}
