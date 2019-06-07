package rabbitescape.engine.newstates.item_states.bridge;

import rabbitescape.engine.ChangeDescription.State;

public class BridgeFalling extends BridgeItemState {

    @Override
    public State getState() {
        return State.TOKEN_BRIDGE_FALLING;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
