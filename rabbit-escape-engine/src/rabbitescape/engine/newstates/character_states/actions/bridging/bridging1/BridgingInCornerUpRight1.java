package rabbitescape.engine.newstates.character_states.actions.bridging.bridging1;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bridging;
import rabbitescape.engine.newstates.character_states.actions.Bridging.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.IBridgingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1;

public class BridgingInCornerUpRight1 implements IBridgingState {

    @Override
    public State getState() {
        return RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        System.out.println("\t\tRABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1");
        character.onSlope = true;
        ;
        return true;
    }
}
