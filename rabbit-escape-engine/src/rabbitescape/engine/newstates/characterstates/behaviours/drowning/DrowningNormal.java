package rabbitescape.engine.newstates.characterstates.behaviours.drowning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.Chars;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_DROWNING;

public class DrowningNormal implements IDrowningState {

    @Override
    public State getState() {
        return RABBIT_DROWNING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.killRabbit(character);
        return true;
    }
}
