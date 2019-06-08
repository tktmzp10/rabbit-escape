package rabbitescape.engine.newstates.item_states.bash;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class BashItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new BashOnSlop();
        } else if (!isMoving) {
            newState = new BashStill();
        } else if (isSlopeBelow) {
            newState = new BashFallToSlope();
        } else {
            newState = new BashFalling();
        }

        return newState;
    }
}
