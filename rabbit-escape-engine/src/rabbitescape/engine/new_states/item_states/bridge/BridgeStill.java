package rabbitescape.engine.new_states.item_states.bridge;

import rabbitescape.engine.ChangeDescription.State;

public class BridgeStill extends BridgeItemState {

    @Override
    public State getState() {
        return State.TOKEN_BRIDGE_STILL;
    }

    @Override
    public boolean isFalling() {
        return false;
    }
}
