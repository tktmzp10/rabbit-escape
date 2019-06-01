package rabbitescape.engine.behaviours.states.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

public class NotBashing implements IBashingState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        character.slopeBashHop = false;
        return false;
    }
}
