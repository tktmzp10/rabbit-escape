package rabbitescape.engine.newstates.item_states.climb;

import rabbitescape.engine.ChangeDescription.State;

public class ClimbOnSlope extends ClimbItemState {

    @Override
    public State getState() {
        return State.TOKEN_CLIMB_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
