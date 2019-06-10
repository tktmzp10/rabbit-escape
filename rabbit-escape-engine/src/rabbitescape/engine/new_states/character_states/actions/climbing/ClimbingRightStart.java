package rabbitescape.engine.new_states.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingRightStart implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_RIGHT_START;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, Climbing climbing) {
        Block endBlock = t.blockAboveNext();

        if (t.isWall(endBlock)) {
            return new ClimbingRightContinue2();
        } else {
            return new ClimbingRightEnd();
        }
    }

    @Override
    public boolean behave(
        World world, Character character, Climbing climbing
    ) {
        climbing.abilityActive = true;
        return true;
    }
}
