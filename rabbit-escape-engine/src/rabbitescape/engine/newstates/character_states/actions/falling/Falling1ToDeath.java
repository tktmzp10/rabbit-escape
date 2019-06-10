package rabbitescape.engine.newstates.character_states.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Falling;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_1_TO_DEATH;

public class Falling1ToDeath implements IFallingState {

    @Override
    public State getState() {
        return RABBIT_FALLING_1_TO_DEATH;
    }

    @Override
    public boolean behave(
        World world, Character character, Falling falling
    ) {
        falling.heightFallen += 1;
        character.y = character.y + 1;
        return true;
    }
}
