package rabbitescape.engine.newstates.character_states.actions.walking.walkingondownslope;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Walking;
import rabbitescape.engine.newstates.character_states.actions.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_RIGHT_TO_LEFT_LOWERING;
import static rabbitescape.engine.Direction.LEFT;

public class TurningRightToLeftLowering implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_TURNING_RIGHT_TO_LEFT_LOWERING;
    }

    @Override
    public boolean behave(World world, Character character) {
        character.dir = LEFT;
        Walking.checkJumpOntoSlope(world, character);
        return true;
    }
}
