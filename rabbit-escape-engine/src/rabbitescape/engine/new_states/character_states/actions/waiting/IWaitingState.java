package rabbitescape.engine.new_states.character_states.actions.waiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IWaitingState {

    public State getState();

    public boolean behave(World world, Character character);
}