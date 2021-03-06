package rabbitescape.engine.new_states.character_states.actions.climbing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.FLAT;
import static rabbitescape.engine.Block.Shape.UP_RIGHT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_END;
import static rabbitescape.engine.Direction.LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class ClimbingRightEndTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private BehaviourTools behaviourTools = new BehaviourTools(character, world);
    private Climbing climbing = new Climbing();
    private ClimbingRightEnd climbingRightEnd = new ClimbingRightEnd();

    @Test
    public void getState() {
        assertEquals(RABBIT_CLIMBING_RIGHT_END, climbingRightEnd.getState());
    }

    @Test
    public void newState() {
        assertNotNull(climbingRightEnd.newState(behaviourTools, climbing));

        world.blockTable.add(new Block(2, 1, EARTH, FLAT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertNotNull(climbingRightEnd.newState(behaviourTools, climbing));

        character = new Rabbit(1, 1, LEFT);
        world.blockTable.add(new Block(0, 1, EARTH, FLAT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertNotNull(climbingRightEnd.newState(behaviourTools, climbing));
    }

    @Test
    public void behave() {
        assertTrue(climbingRightEnd.behave(world, character, climbing));

        character = new Rabbit(1, 1, RIGHT);
        world.blockTable.add(new Block(2, 0, EARTH, UP_RIGHT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertTrue(climbingRightEnd.behave(world, character, climbing));
    }
}