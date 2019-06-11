package rabbitescape.engine.new_states.character_states.actions.brollychuting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public class NotBrollychuting implements IBrollychutingState {

    @Override
    public State getState() {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
