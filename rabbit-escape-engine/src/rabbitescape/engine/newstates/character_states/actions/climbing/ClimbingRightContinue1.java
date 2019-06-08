package rabbitescape.engine.newstates.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_CONTINUE_1;

public class ClimbingRightContinue1 implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_RIGHT_CONTINUE_1;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, Climbing climbing) {
        return new ClimbingRightContinue2();
    }

    @Override
    public boolean behave(
        World world, Character character, Climbing climbing
    ) {
        climbing.abilityActive = true;
        return true;
    }
}
