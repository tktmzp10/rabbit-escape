package rabbitescape.engine.new_states.character_states.actions.digging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_DIGGING;

public class DiggingNormal implements IDiggingState {

    @Override
    public State getState() {
        return RABBIT_DIGGING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.removeBlockAt(character.x, character.y + 1);
        ++character.y;
        return true;
    }
}
