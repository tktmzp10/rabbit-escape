package rabbitescape.engine.new_states.character_states.actions.waiting;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_WAITING_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class WaitingLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private WaitingLeft waitingLeft = new WaitingLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_WAITING_LEFT, waitingLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(waitingLeft.behave(world, character));
    }
}