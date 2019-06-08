package rabbitescape.engine.newstates.character_states.actions.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public class NotBashing implements IBashingState {

    @Override
    public State getState() {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        character.slopeBashHop = false;
        return false;
    }
}
