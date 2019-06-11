package rabbitescape.engine.new_states.character_states.actions.climbing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.FLAT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_LEFT_BANG_HEAD;
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

public class ClimbingLeftBangHeadTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private BehaviourTools behaviourTools = new BehaviourTools(character, world);
    private Climbing climbing = new Climbing();
    private ClimbingLeftBangHead climbingLeftBangHead = new ClimbingLeftBangHead();

    @Test
    public void getState() {
        assertEquals(RABBIT_CLIMBING_LEFT_BANG_HEAD, climbingLeftBangHead.getState());
    }

    @Test
    public void newState() {
        assertNotNull(climbingLeftBangHead.newState(behaviourTools, climbing));

        world.blockTable.add(new Block(2, 1, EARTH, FLAT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertNotNull(climbingLeftBangHead.newState(behaviourTools, climbing));

        character = new Rabbit(1, 1, LEFT);
        world.blockTable.add(new Block(0, 1, EARTH, FLAT, 4));
        behaviourTools = new BehaviourTools(character, world);
        assertNotNull(climbingLeftBangHead.newState(behaviourTools, climbing));
    }

    @Test
    public void behave() {
        assertTrue(climbingLeftBangHead.behave(world, character, climbing));
    }
}