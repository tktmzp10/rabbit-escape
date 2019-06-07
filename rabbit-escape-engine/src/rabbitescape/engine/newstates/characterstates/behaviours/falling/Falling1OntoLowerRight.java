package rabbitescape.engine.newstates.characterstates.behaviours.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_1_ONTO_LOWER_RIGHT;

public class Falling1OntoLowerRight implements IFallingState {

    @Override
    public State newState() {
        return RABBIT_FALLING_1_ONTO_LOWER_RIGHT;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
