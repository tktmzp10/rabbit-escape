package rabbitescape.engine.new_states.item_states.bash;

import rabbitescape.engine.ChangeDescription.State;

public class BashStill extends BashItemState {

    @Override
    public State getState() {
        return State.TOKEN_BASH_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
