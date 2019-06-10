package rabbitescape.engine.newstates.character_states.actions.bridging.bridging2;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bridging;
import rabbitescape.engine.newstates.character_states.actions.Bridging.BridgeType;
import rabbitescape.engine.newstates.character_states.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_DOWN_UP_LEFT_2;

public class BridgingDownUpLeft2 implements IBridgingState {

    @Override
    public State getState() {
        return RABBIT_BRIDGING_DOWN_UP_LEFT_2;
    }

    @Override
    public boolean behave(World world, Character character, Bridging bridging) {
        character.onSlope = true;
        bridging.bridgeType = BridgeType.DOWN_UP;
        return true;
    }
}
