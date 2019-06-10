package rabbitescape.engine.new_states.character_states.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_LEFT_BANG_HEAD;
import static rabbitescape.engine.Direction.RIGHT;
import static rabbitescape.engine.Direction.opposite;

public class ClimbingLeftBangHead implements IClimbingState {

    @Override
    public State getState() {
        return RABBIT_CLIMBING_LEFT_BANG_HEAD;
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
        character.dir = opposite(character.dir);
        return true;
    }
}
