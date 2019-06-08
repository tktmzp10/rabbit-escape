package rabbitescape.engine.newstates.item_states.dig;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class DigItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new DigOnSlop();
        } else if (!isMoving) {
            newState = new DigStill();
        } else if (isSlopeBelow) {
            newState = new DigFallToSlope();
        } else {
            newState = new DigFalling();
        }

        return newState;
    }

}
