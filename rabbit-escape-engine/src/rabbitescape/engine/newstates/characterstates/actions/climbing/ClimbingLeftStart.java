package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingLeftStart implements IClimbingState
{
    @Override
    public State newState( BehaviourTools t, boolean abilityActive )
    {
        Block endBlock = t.blockAboveNext();

        if ( t.isWall( endBlock ) )
        {
            return RABBIT_CLIMBING_LEFT_CONTINUE_2;
        }
        else
        {
            return RABBIT_CLIMBING_LEFT_END;
        }
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
