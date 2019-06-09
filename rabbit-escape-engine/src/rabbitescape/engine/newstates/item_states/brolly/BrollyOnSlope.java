package rabbitescape.engine.newstates.item_states.brolly;

import rabbitescape.engine.ChangeDescription.State;

public class BrollyOnSlope extends BrollyItemState {

    @Override
    public State getState() {
        return State.TOKEN_BROLLY_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
