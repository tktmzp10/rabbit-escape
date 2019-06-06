package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingRightContinue2 implements IClimbingState
{
    @Override
    public State newState( BehaviourTools t, boolean abilityActive )
    {
        Block aboveBlock = t.blockAbove();

        if ( t.isRoof( aboveBlock ) )
        {
            abilityActive = false;
            return RABBIT_CLIMBING_RIGHT_BANG_HEAD;
        }

        Block endBlock = t.blockAboveNext();

        if ( t.isWall( endBlock ) )
        {
            return RABBIT_CLIMBING_RIGHT_CONTINUE_1;
        }
        else
        {
            return RABBIT_CLIMBING_RIGHT_END;
        }
    }

    @Override
    public boolean behave(
        World world, Character character, boolean abilityActive
    )
    {
        abilityActive = true;
        --character.y;
        return true;
    }
}
