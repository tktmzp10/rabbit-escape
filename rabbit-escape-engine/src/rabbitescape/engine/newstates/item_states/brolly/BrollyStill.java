package rabbitescape.engine.newstates.item_states.brolly;

import rabbitescape.engine.ChangeDescription.State;

public class BrollyStill extends BrollyItemState {

    @Override
    public State getState() {
        return State.TOKEN_BROLLY_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
