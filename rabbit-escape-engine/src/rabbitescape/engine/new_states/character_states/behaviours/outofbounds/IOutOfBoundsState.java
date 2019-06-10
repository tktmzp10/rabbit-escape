package rabbitescape.engine.new_states.character_states.behaviours.outofbounds;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public interface IOutOfBoundsState {

    public State getState();

    public boolean behave(World world, Character character);
}
