package rabbitescape.engine.newstates.character_states.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_DYING_OF_FALLING;

public class DyingOfFalling implements IFallingState {

    @Override
    public State newState() {
        return RABBIT_DYING_OF_FALLING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
