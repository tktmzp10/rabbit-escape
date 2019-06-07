package rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonflat;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.characterstates.behaviours.Walking;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.IWalkingState;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_LEFT_TO_RIGHT;
import static rabbitescape.engine.Direction.RIGHT;

public class TurningLeftToRight implements IWalkingState {

    @Override
    public State getState() {
        return RABBIT_TURNING_LEFT_TO_RIGHT;
    }

    @Override
    public boolean behave(  World world, Character character ) {
        character.onSlope = false;
        character.dir = RIGHT;
        Walking.checkJumpOntoSlope(world, character);
        return true;
    }
}
