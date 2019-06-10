package rabbitescape.engine.new_states.character_states.actions.waiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_WAITING_RIGHT;

public class WaitingRight implements IWaitingState {

    @Override
    public State newState() {
        return RABBIT_WAITING_RIGHT;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return true;
    }
}
