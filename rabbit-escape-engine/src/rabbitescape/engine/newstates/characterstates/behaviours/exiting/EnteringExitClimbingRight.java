package rabbitescape.engine.newstates.characterstates.behaviours.exiting;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_ENTERING_EXIT_CLIMBING_RIGHT;

public class EnteringExitClimbingRight implements IExitingState
{
    @Override
    public State getState()
    {
        return RABBIT_ENTERING_EXIT_CLIMBING_RIGHT;
    }

    @Override
    public boolean behave(
        World world, Character character
    )
    {
        world.changes.saveRabbit( character );
        return true;
    }
}