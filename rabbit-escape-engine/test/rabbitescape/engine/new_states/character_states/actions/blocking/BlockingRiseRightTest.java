package rabbitescape.engine.new_states.character_states.actions.blocking;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BLOCKING_RISE_RIGHT;

import org.junit.Test;

public class BlockingRiseRightTest {

    private BlockingRiseRight blockingRiseRight = new BlockingRiseRight();

    @Test
    public void getState() {
        assertEquals(RABBIT_BLOCKING_RISE_RIGHT, blockingRiseRight.getState());
    }

    @Test
    public void behave() {
        assertTrue(blockingRiseRight.behave());
    }
}