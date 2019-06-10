package rabbitescape.engine.newstates.item_states;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.NewStates;

public abstract class ItemState extends NewStates {
    private boolean isMoving;
    private boolean isSlopeBelow;
    private boolean isOnSlope;

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isSlopeBelow() {
        return isSlopeBelow;
    }

    public void setSlopeBelow(boolean slopeBelow) {
        isSlopeBelow = slopeBelow;
    }

    public boolean isOnSlope() {
        return isOnSlope;
    }

    public void setOnSlope(boolean onSlope) {
        isOnSlope = onSlope;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        return null;
    }

    public abstract ItemState newState();

    public abstract boolean isFalling();
}
