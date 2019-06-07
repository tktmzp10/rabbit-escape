package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingRightContinue2 implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_RIGHT_CONTINUE_2;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, boolean abilityActive) {
        Block aboveBlock = t.blockAbove();

        if (t.isRoof(aboveBlock)) {
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
        World world, Character character, boolean abilityActive
    ) {
        abilityActive = true;
        --character.y;
        return true;
    }
}
