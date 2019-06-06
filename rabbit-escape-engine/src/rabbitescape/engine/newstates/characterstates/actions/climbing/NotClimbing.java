package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_LEFT_START;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_START;
import static rabbitescape.engine.Direction.RIGHT;

public class NotClimbing implements IClimbingState
{
    @Override
    public State newState( BehaviourTools t, boolean abilityActive, IClimbingState climbingState )
    {
        int nextX = t.nextX();
        int nextY = t.nextY();
        Block nextBlock = t.world.getBlockAt( nextX, nextY );
        Block aboveBlock = t.world.getBlockAt( t.character.x, t.character.y - 1 );

        if ( !t.isRoof( aboveBlock ) && t.isWall( nextBlock ) )
        {
            if ( t.character.dir == RIGHT )
            {
                climbingState = new ClimbingRightStart();
                return RABBIT_CLIMBING_RIGHT_START;
            }
            else
            {
                climbingState = new ClimbingLeftStart();
                return RABBIT_CLIMBING_LEFT_START;
            }
        }

        climbingState = new NotClimbing();
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
