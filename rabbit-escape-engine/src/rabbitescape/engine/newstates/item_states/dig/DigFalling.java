package rabbitescape.engine.newstates.item_states.dig;

import rabbitescape.engine.ChangeDescription.State;

public class DigFalling extends DigItemState {

    @Override
    public State getState() {
        return State.TOKEN_DIG_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
