package rabbitescape.engine.newstates.character_states.behaviours.burning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BURNING_ON_SLOPE;

public class BurningOnSlope implements IBurningState {

    @Override
    public State getState() {
        return RABBIT_BURNING_ON_SLOPE;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.killRabbit(character);
        return false;
    }
}
