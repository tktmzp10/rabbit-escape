package rabbitescape.engine.new_states.item_states.brolly;

import rabbitescape.engine.ChangeDescription.State;

public class BrollyFalling extends BrollyItemState {

    @Override
    public State getState() {
        return State.TOKEN_BROLLY_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
