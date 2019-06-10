package rabbitescape.engine.newstates.item_states.bash;

import rabbitescape.engine.newstates.ItemState;

public abstract class BashItemState extends ItemState {

    @Override
    public ItemState newState() {
        ItemState newState;

        if (isOnSlope()) {
            newState = new BashOnSlope();
        } else if (!isMoving()) {
            newState = new BashStill();
        } else if (isSlopeBelow()) {
            newState = new BashFallToSlope();
        } else {
            newState = new BashFalling();
        }

        return newState;
    }
}
