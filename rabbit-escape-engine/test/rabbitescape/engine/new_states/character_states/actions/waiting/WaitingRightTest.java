package rabbitescape.engine.new_states.character_states.actions.waiting;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_WAITING_RIGHT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class WaitingRightTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private WaitingRight waitingRight = new WaitingRight();

    @Test
    public void getState() {
        assertEquals(RABBIT_WAITING_RIGHT, waitingRight.getState());
    }

    @Test
    public void behave() {
        assertTrue(waitingRight.behave(world, character));
    }
}