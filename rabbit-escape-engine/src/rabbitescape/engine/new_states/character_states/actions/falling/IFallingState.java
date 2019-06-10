package rabbitescape.engine.new_states.character_states.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Falling;
import rabbitescape.engine.things.Character;

public interface IFallingState {

    public State getState();

    public boolean behave(World world, Character character, Falling falling);
}