package rabbitescape.engine.new_states.character_states.actions.digging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IDiggingState {

    public State getState();

    public boolean behave(World world, Character character);
}
