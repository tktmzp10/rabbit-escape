package rabbitescape.engine.newstates.character_states.actions.bridging.bridging1;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bridging.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_UP_RIGHT_1;

public class BridgingUpRight1 implements IBridgingState {

    @Override
    public State newState() {
        return RABBIT_BRIDGING_UP_RIGHT_1;
    }

    @Override
    public boolean behave(
        World world, Character character, BridgeType bridgeType
    ) {
        character.onSlope = true;
        bridgeType = BridgeType.UP;
        return true;
    }
}
