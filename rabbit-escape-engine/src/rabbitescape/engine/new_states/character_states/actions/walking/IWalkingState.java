package rabbitescape.engine.new_states.character_states.actions.walking;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IWalkingState {

    public State getState();

    public boolean behave(World world, Character character);
}
