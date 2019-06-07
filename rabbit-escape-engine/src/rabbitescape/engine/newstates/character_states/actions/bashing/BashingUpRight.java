package rabbitescape.engine.newstates.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bashing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_UP_RIGHT;
import static rabbitescape.engine.Direction.RIGHT;

public class BashingUpRight implements IBashingState {

    @Override
    public State newState() {
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
