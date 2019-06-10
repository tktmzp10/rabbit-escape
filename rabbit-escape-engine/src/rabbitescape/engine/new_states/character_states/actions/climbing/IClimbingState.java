package rabbitescape.engine.new_states.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

public interface IClimbingState {

    public State getState();

    public IClimbingState newState(BehaviourTools t, Climbing climbing);

    public boolean behave(World world, Character character, Climbing climbing);
}
