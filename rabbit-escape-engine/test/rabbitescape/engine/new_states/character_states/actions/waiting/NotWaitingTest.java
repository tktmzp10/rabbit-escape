package rabbitescape.engine.new_states.character_states.actions.waiting;

import static org.junit.Assert.*;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.digging.DiggingNormal;
import rabbitescape.engine.new_states.character_states.actions.digging.NotDigging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class NotWaitingTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private NotWaiting notWaiting = new NotWaiting();

    @Test
    public void getState() {
        assertNull(notWaiting.getState());
    }

    @Test
    public void behave() {
        assertFalse(notWaiting.behave(world, character));
    }
}