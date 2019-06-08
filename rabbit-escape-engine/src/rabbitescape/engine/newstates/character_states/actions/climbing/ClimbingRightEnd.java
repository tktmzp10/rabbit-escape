package rabbitescape.engine.newstates.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_END;
import static rabbitescape.engine.Direction.RIGHT;

public class ClimbingRightEnd implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_RIGHT_END;
    }

    @Override
    public IClimbingState newState(BehaviourTools t, Climbing climbing) {
        int nextX = t.nextX();
        int nextY = t.nextY();
        Block nextBlock = t.world.getBlockAt(nextX, nextY);
        Block aboveBlock = t.world.getBlockAt(t.character.x, t.character.y - 1);

        if (!t.isRoof(aboveBlock) && t.isWall(nextBlock)) {
            if (t.character.dir == RIGHT) {
                return new ClimbingRightStart();
            } else {
                return new ClimbingLeftStart();
            }
        }

        return new NotClimbing();
    }

    @Override
    public boolean behave(
        World world, Character character, Climbing climbing
    ) {
        BehaviourTools t = new BehaviourTools(character, world);

        character.x = t.nextX();
        --character.y;
        if (t.hereIsUpSlope()) {
            character.onSlope = true;
        }
        climbing.abilityActive = false;
        return true;
    }
}
