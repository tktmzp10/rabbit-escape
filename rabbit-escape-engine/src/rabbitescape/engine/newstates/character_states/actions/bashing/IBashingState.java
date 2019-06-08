package rabbitescape.engine.newstates.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IBashingState {

    public State getState();

    public boolean behave(World world, Character character);
}
