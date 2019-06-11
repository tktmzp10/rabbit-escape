package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_LEFT_TO_RIGHT_LOWERING;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class TurningLeftToRightLoweringTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private TurningLeftToRightLowering turningLeftToRightLowering = new TurningLeftToRightLowering();

    @Test
    public void getState() {
        assertEquals(RABBIT_TURNING_LEFT_TO_RIGHT_LOWERING, turningLeftToRightLowering.getState());
    }

    @Test
    public void behave() {
        assertTrue(turningLeftToRightLowering.behave(world, character));
    }
}