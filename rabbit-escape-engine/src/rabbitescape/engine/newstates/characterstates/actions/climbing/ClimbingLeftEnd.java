package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_LEFT_END;

public class ClimbingLeftEnd implements IClimbingState
{
    @Override
    public State newState()
    {
        return RABBIT_CLIMBING_LEFT_END;
    }

    @Override
    public boolean behave(
        World world, Character character, boolean abilityActive
    )
    {
        BehaviourTools t = new BehaviourTools( character, world );

        character.x = t.nextX();
        --character.y;
        if ( t.hereIsUpSlope() )
        {
            character.onSlope = true;
        }
        abilityActive = false;
        return true;
    }
}
