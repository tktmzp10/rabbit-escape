package rabbitescape.engine.new_states.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingRightContinue2 implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_RIGHT_CONTINUE_2;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, Climbing climbing) {
        Block aboveBlock = t.blockAbove();

        if (t.isRoof(aboveBlock)) {
            climbing.abilityActive = false;
            return new ClimbingRightBangHead();
        }

        Block endBlock = t.blockAboveNext();

        if (t.isWall(endBlock)) {
            return new ClimbingRightContinue1();
        } else {
            return new ClimbingRightEnd();
        }
    }

    @Override
    public boolean behave(
        World world, Character character, Climbing climbing
    ) {
        climbing.abilityActive = true;
        --character.y;
        return true;
    }
}
