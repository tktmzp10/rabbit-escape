package rabbitescape.engine.new_states.character_states.behaviours.burning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BURNING;

public class BurningNormal implements IBurningState {

    @Override
    public State getState() {
        return RABBIT_BURNING;
    }

    @Override
    public boolean behave(World world, Character character) {
        world.changes.killRabbit(character);
        return true;
    }
}
