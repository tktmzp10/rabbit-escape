package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public class NotClimbing implements IClimbingState
{
    @Override
    public State newState()
    {
        return null;
    }

    @Override
    public boolean behave(
        World world, Character character, boolean abilityActive
    )
    {
        return false;
    }
}
