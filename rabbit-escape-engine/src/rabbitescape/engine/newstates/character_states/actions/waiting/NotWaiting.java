package rabbitescape.engine.newstates.character_states.actions.waiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public class NotWaiting implements IWaitingState {

    @Override
    public State newState() {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        return false;
    }
}
