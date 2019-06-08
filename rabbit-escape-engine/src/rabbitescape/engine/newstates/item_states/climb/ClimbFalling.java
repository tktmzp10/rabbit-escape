package rabbitescape.engine.newstates.item_states.climb;

import rabbitescape.engine.ChangeDescription.State;

public class ClimbFalling extends ClimbItemState {

    @Override
    public State getState() {
        return State.TOKEN_CLIMB_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
