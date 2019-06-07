package rabbitescape.engine.newstates.character_states.behaviours.exiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public interface IExitingState {

    public State getState();

    public boolean behave(World world, Character character);
}
