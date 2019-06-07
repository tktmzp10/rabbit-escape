package rabbitescape.engine.newstates.character_states.behaviours.exploding;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_EXPLODING;

public class ExplodingNormal implements IExplodingState {

    @Override
    public State getState() {
        return RABBIT_EXPLODING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.killRabbit(character);
        return true;
    }
}
