package rabbitescape.engine.new_states.item_states.bridge;

import rabbitescape.engine.ChangeDescription.State;

public class BridgeOnSlope extends BridgeItemState {

    @Override
    public State getState() {
        return State.TOKEN_BRIDGE_ON_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
