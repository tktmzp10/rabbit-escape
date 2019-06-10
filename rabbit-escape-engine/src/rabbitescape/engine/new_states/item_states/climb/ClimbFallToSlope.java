package rabbitescape.engine.new_states.item_states.climb;

import rabbitescape.engine.ChangeDescription.State;

public class ClimbFallToSlope extends ClimbItemState {

    @Override
    public State getState() {
        return State.TOKEN_CLIMB_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
