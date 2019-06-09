package rabbitescape.engine.newstates.item_states.bash;

import rabbitescape.engine.ChangeDescription.State;

public class BashOnSlope extends BashItemState {

    @Override
    public State getState() {
        return State.TOKEN_BASH_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
