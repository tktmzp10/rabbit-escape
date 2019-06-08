package rabbitescape.engine.newstates.item_states.dig;

import rabbitescape.engine.ChangeDescription.State;

public class DigFallToSlope extends DigItemState {

    @Override
    public State getState() {
        return State.TOKEN_DIG_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
