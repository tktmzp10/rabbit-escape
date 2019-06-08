package rabbitescape.engine.newstates.item_states.explode;

import rabbitescape.engine.ChangeDescription.State;

public class ExplodeFalling extends ExplodeItemState {

    @Override
    public State getState() {
        return State.TOKEN_EXPLODE_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
