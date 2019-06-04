package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_LEFT_CONTINUE_1;

public class ClimbingLeftContinue1 implements IClimbingState
{
    @Override
    public State newState()
    {
        return RABBIT_CLIMBING_LEFT_CONTINUE_1;
    }

    @Override
    public boolean behave(
        World world, Character character, boolean abilityActive
    )
    {
        abilityActive = true;
        return true;
    }
}
