package rabbitescape.engine.newstates.item_states.explode;

import rabbitescape.engine.ChangeDescription.State;

public class ExplodeStill extends ExplodeItemState {

    @Override
    public State getState() {
        return State.TOKEN_EXPLODE_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
