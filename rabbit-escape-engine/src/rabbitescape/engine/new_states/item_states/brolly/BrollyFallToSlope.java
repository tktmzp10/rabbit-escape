package rabbitescape.engine.new_states.item_states.brolly;

import rabbitescape.engine.ChangeDescription.State;

public class BrollyFallToSlope extends BrollyItemState {

    @Override
    public State getState() {
        return State.TOKEN_BROLLY_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
