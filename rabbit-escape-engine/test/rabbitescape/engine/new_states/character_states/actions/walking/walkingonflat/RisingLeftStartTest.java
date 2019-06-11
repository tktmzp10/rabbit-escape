package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_RISING_LEFT_START;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class RisingLeftStartTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private RisingLeftStart risingLeftStart = new RisingLeftStart();

    @Test
    public void getState() {
        assertEquals(RABBIT_RISING_LEFT_START, risingLeftStart.getState());
    }

    @Test
    public void behave() {
        assertTrue(risingLeftStart.behave(world, character));
    }
}