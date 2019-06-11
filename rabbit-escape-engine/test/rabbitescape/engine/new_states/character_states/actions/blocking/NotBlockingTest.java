package rabbitescape.engine.new_states.character_states.actions.blocking;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotBlockingTest {

    private NotBlocking notBlocking = new NotBlocking();

    @Test
    public void getState() {
        assertNull(notBlocking.getState());
    }

    @Test
    public void behave() {
        assertFalse(notBlocking.behave());
    }
}