package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_RIGHT_START;

public class LoweringRightStart implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_LOWERING_RIGHT_START;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        ++character.y;
        ++character.x;
        character.onSlope = true;
        return true;
    }
}
