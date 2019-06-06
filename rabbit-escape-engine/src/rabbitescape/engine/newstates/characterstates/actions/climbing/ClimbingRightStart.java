package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingRightStart implements IClimbingState
{
    @Override
    public State newState( BehaviourTools t, boolean abilityActive, IClimbingState climbingState )
    {
        System.out.println( "\t\tClimbingRightStart.newState()" );
        Block endBlock = t.blockAboveNext();

        if ( t.isWall( endBlock ) )
        {
            System.out.println( "\t\t\tRABBIT_CLIMBING_RIGHT_CONTINUE_2" );
            climbingState = new ClimbingRightContinue2();
            return RABBIT_CLIMBING_RIGHT_CONTINUE_2;
        }
        else
        {
            System.out.println( "\t\t\tRABBIT_CLIMBING_RIGHT_END" );
            climbingState = new ClimbingRightEnd();
            return RABBIT_CLIMBING_RIGHT_END;
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
