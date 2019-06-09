package rabbitescape.engine.newstates.item_states.brolly;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class BrollyItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new BrollyOnSlope();
        } else if (!isMoving) {
            newState = new BrollyStill();
        } else if (isSlopeBelow) {
            newState = new BrollyFallToSlope();
        } else {
            newState = new BrollyFalling();
        }

        return newState;
    }

}
