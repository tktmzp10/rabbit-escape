package rabbitescape.engine.newstates.characterstates.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_1;

public class Falling1 implements IFallingState {

    @Override
    public State newState() {
        return RABBIT_FALLING_1;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
