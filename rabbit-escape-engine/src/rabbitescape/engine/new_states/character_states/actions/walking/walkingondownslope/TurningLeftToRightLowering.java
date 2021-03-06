package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Walking;
import rabbitescape.engine.new_states.character_states.actions.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_LEFT_TO_RIGHT_LOWERING;
import static rabbitescape.engine.Direction.RIGHT;

public class TurningLeftToRightLowering implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_TURNING_LEFT_TO_RIGHT_LOWERING;
    }

    @Override
    public boolean behave(World world, Character character) {
        character.dir = RIGHT;
        Walking.checkJumpOntoSlope(world, character);
        return true;
    }
}
