package rabbitescape.engine.new_states.character_states.actions.climbing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.FLAT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_START;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class ClimbingRightStartTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private BehaviourTools behaviourTools = new BehaviourTools(character, world);
    private Climbing climbing = new Climbing();
    private ClimbingRightStart climbingRightStart = new ClimbingRightStart();

    @Test
    public void getState() {
        assertEquals(RABBIT_CLIMBING_RIGHT_START, climbingRightStart.getState());
    }

    @Test
    public void newState() {
        assertNotNull(climbingRightStart.newState(behaviourTools, climbing));
        world.blockTable.add(new Block(2, 0, EARTH, FLAT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertNotNull(climbingRightStart.newState(behaviourTools, climbing));
    }

    @Test
    public void behave() {
        assertTrue(climbingRightStart.behave(world, character, climbing));
    }
}