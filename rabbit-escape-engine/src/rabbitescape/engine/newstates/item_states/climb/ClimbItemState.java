package rabbitescape.engine.newstates.item_states.climb;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class ClimbItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new ClimbOnSlope();
        } else if (!isMoving) {
            newState = new ClimbStill();
        } else if (isSlopeBelow) {
            newState = new ClimbFallToSlope();
        } else {
            newState = new ClimbFalling();
        }

        return newState;
    }

}
