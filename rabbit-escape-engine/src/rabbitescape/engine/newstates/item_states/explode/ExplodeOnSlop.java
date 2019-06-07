package rabbitescape.engine.newstates.item_states.explode;

import rabbitescape.engine.ChangeDescription.State;

public class ExplodeOnSlop extends ExplodeItemState {

    @Override
    public State getState() {
        return State.TOKEN_EXPLODE_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
