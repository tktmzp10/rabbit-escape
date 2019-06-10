package rabbitescape.engine.new_states.item_states.bash;

import rabbitescape.engine.ChangeDescription.State;

public class BashFallToSlope extends BashItemState {

    @Override
    public State getState() {
        return State.TOKEN_BASH_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
