package rabbitescape.engine.newstates.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bashing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_RIGHT;
import static rabbitescape.engine.Direction.RIGHT;

public class BashingRight implements IBashingState {

    @Override
    public State getState() {
        return RABBIT_BASHING_RIGHT;
    }

    @Override
    public boolean behave(World world, Character character) {
        character.slopeBashHop = false;
        world.changes.removeBlockAt(Bashing.destX(character), character.y);
        return true;
    }
}
