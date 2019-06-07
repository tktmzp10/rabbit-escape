package rabbitescape.engine.newstates.character_states.behaviours.drowning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public class NotDrowning implements IDrowningState {

    @Override
    public State getState() {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
