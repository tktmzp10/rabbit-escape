package rabbitescape.engine.new_states.character_states.actions.blocking;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BLOCKING_RISE_LEFT;

import org.junit.Test;

public class BlockingRiseLeftTest {

    private BlockingRiseLeft blockingRiseLeft = new BlockingRiseLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_BLOCKING_RISE_LEFT, blockingRiseLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(blockingRiseLeft.behave());
    }
}