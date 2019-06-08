package rabbitescape.engine.newstates.item_states.explode;

import rabbitescape.engine.newstates.item_states.ItemState;

public abstract class ExplodeItemState extends ItemState {

    @Override
    public ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope) {
        ItemState newState;

        if (isOnSlope) {
            newState = new ExplodeOnSlop();
        } else if (!isMoving) {
            newState = new ExplodeStill();
        } else if (isSlopeBelow) {
            newState = new ExplodeFallToSlope();
        } else {
            newState = new ExplodeFalling();
        }

        return newState;
    }

}
