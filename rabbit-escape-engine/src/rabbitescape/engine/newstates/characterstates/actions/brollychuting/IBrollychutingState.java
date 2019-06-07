package rabbitescape.engine.newstates.characterstates.actions.brollychuting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IBrollychutingState {

    public State newState();

    public boolean behave(World world, Character character);
}