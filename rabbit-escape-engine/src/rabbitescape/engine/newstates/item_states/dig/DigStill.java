package rabbitescape.engine.newstates.item_states.dig;

import rabbitescape.engine.ChangeDescription.State;

public class DigStill extends DigItemState {

    @Override
    public State getState() {
        return State.TOKEN_DIG_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
