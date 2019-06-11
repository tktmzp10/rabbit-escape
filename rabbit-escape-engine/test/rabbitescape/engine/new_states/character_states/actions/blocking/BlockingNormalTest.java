package rabbitescape.engine.new_states.character_states.actions.blocking;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BLOCKING;

import org.junit.Test;

public class BlockingNormalTest {

    private BlockingNormal blockingNormal = new BlockingNormal();

    @Test
    public void getState() {
        assertEquals(RABBIT_BLOCKING, blockingNormal.getState());
    }

    @Test
    public void behave() {
        assertTrue(blockingNormal.behave());
    }
}