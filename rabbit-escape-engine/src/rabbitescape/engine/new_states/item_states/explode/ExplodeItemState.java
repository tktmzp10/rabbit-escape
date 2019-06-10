package rabbitescape.engine.new_states.item_states.explode;

import rabbitescape.engine.new_states.ItemState;

public abstract class ExplodeItemState extends ItemState {

    @Override
    public ItemState newState() {
        ItemState newState;

        if (isOnSlope()) {
            newState = new ExplodeOnSlope();
        } else if (!isMoving()) {
            newState = new ExplodeStill();
        } else if (isSlopeBelow()) {
            newState = new ExplodeFallToSlope();
        } else {
            newState = new ExplodeFalling();
        }

        return newState;
    }

}
