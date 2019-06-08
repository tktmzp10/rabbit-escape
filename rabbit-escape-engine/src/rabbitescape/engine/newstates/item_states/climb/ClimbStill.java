package rabbitescape.engine.newstates.item_states.climb;

import rabbitescape.engine.ChangeDescription.State;

public class ClimbStill extends ClimbItemState {

    @Override
    public State getState() {
        return State.TOKEN_CLIMB_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
