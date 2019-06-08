package rabbitescape.engine.newstates.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_USELESSLY_RIGHT_UP;

public class BashingUselesslyRightUp implements IBashingState {

    @Override
    public State getState() {
        return RABBIT_BASHING_USELESSLY_RIGHT_UP;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        character.slopeBashHop = true;
        character.y -= 1;
        return true;
    }
}
