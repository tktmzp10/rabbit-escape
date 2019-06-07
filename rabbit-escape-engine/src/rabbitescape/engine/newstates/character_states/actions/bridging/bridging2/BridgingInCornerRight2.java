package rabbitescape.engine.newstates.character_states.actions.bridging.bridging2;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bridging.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_RIGHT_2;

public class BridgingInCornerRight2 implements IBridgingState {

    @Override
    public State newState() {
        return RABBIT_BRIDGING_IN_CORNER_RIGHT_2;
    }

    @Override
    public boolean behave(
        World world, Character character, BridgeType bridgeType
    ) {
        character.onSlope = true;
        bridgeType = BridgeType.ALONG;
        return true;
    }
}
