package rabbitescape.engine.new_states.character_states.actions.waiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_WAITING_LEFT;

public class WaitingLeft implements IWaitingState {

    @Override
    public State getState() {
        return RABBIT_WAITING_LEFT;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return true;
    }
}
