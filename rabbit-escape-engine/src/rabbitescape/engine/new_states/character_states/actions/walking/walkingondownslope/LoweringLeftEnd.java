package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_LEFT_END;

public class LoweringLeftEnd implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_LOWERING_LEFT_END;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        --character.x;
        character.onSlope = false;
        return true;
    }
}
