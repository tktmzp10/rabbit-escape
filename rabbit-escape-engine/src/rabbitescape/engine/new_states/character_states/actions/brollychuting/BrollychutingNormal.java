package rabbitescape.engine.new_states.character_states.actions.brollychuting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BROLLYCHUTING;

public class BrollychutingNormal implements IBrollychutingState {

    @Override
    public State getState() {
        return RABBIT_BROLLYCHUTING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        character.y = character.y + 1;
        return true;
    }
}
