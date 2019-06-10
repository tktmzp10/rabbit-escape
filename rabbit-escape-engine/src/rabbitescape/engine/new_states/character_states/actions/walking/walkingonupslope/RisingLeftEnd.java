package rabbitescape.engine.new_states.character_states.actions.walking.walkingonupslope;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_RISING_LEFT_END;

public class RisingLeftEnd implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_RISING_LEFT_END;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        --character.y;
        --character.x;
        character.onSlope = false;
        return true;
    }
}
