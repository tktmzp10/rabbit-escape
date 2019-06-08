package rabbitescape.engine.newstates.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.*;

public class ClimbingLeftStart implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_LEFT_START;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, boolean abilityActive) {
        Block endBlock = t.blockAboveNext();

        if (t.isWall(endBlock)) {
            return new ClimbingLeftContinue2();
        } else {
            return new ClimbingLeftEnd();
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
