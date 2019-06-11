package rabbitescape.engine.new_states.character_states.actions.climbing;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CLIMBING_RIGHT_CONTINUE_1;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class ClimbingRightContinue1Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private BehaviourTools behaviourTools = new BehaviourTools(character, world);
    private Climbing climbing = new Climbing();
    private ClimbingRightContinue1 climbingRightContinue1 = new ClimbingRightContinue1();

    @Test
    public void getState() {
        assertEquals(RABBIT_CLIMBING_RIGHT_CONTINUE_1, climbingRightContinue1.getState());
    }

    @Test
    public void newState() {
        assertNotNull(climbingRightContinue1.newState(behaviourTools, climbing));
    }

    @Test
    public void behave() {
        assertTrue(climbingRightContinue1.behave(world, character, climbing));
    }
}