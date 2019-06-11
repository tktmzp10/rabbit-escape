package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_TURNING_RIGHT_TO_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class TurningRightToLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private TurningRightToLeft turningRightToLeft = new TurningRightToLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_TURNING_RIGHT_TO_LEFT, turningRightToLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(turningRightToLeft.behave(world, character));
    }
}