package rabbitescape.engine.new_states.item_states.explode;

import rabbitescape.engine.ChangeDescription.State;

public class ExplodeFallToSlope extends ExplodeItemState {

    @Override
    public State getState() {
        return State.TOKEN_EXPLODE_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
