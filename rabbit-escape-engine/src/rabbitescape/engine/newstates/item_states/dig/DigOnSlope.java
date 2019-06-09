package rabbitescape.engine.newstates.item_states.dig;

import rabbitescape.engine.ChangeDescription.State;

public class DigOnSlope extends DigItemState {

    @Override
    public State getState() {
        return State.TOKEN_DIG_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
