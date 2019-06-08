package rabbitescape.engine.newstates.character_states.actions.bridging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Bridging;
import rabbitescape.engine.newstates.character_states.actions.Bridging.*;
import rabbitescape.engine.things.Character;

public interface IBridgingState {

    public State newState();

    public boolean behave(World world, Character character, Bridging bridging);
}