package rabbitescape.engine.newstates.item_states.bridge;

import rabbitescape.engine.ChangeDescription.State;

public class BridgeFallToSlope extends BridgeItemState {

    @Override
    public State getState() {
        return State.TOKEN_BRIDGE_FALL_TO_SLOPE;
    }

    @Override
    public boolean isFalling() {
        return true;
    }
}
