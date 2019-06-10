package rabbitescape.engine.new_states.item_states.climb;

import rabbitescape.engine.new_states.ItemState;

public abstract class ClimbItemState extends ItemState {

    @Override
    public ItemState newState() {
        ItemState newState;

        if (isOnSlope()) {
            newState = new ClimbOnSlope();
        } else if (!isMoving()) {
            newState = new ClimbStill();
        } else if (isSlopeBelow()) {
            newState = new ClimbFallToSlope();
        } else {
            newState = new ClimbFalling();
        }

        return newState;
    }

}
