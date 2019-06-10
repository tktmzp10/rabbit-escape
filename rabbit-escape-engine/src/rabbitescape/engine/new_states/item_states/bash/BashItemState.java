package rabbitescape.engine.new_states.item_states.bash;

import rabbitescape.engine.new_states.ItemState;

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
