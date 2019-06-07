package rabbitescape.engine.newstates.item_states;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.NewStates;

public abstract class ItemState extends NewStates {

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        return null;
    }

    public abstract ItemState newState(boolean isMoving, boolean isSlopeBelow, boolean isOnSlope);

    public abstract boolean isFalling();
}
