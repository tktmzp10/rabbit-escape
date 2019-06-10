package rabbitescape.engine.new_states.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bashing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_UP_RIGHT;

public class BashingUpRight implements IBashingState {

    @Override
    public State getState() {
        return RABBIT_BASHING_UP_RIGHT;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.removeBlockAt(Bashing.destX(character), character.y - 1);
        character.slopeBashHop = true;
        character.y -= 1;
        return true;
    }
}
