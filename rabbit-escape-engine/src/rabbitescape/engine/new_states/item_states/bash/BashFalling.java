package rabbitescape.engine.new_states.item_states.bash;

import rabbitescape.engine.ChangeDescription.State;

public class BashFalling extends BashItemState {

    @Override
    public State getState() {
        return State.TOKEN_BASH_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
