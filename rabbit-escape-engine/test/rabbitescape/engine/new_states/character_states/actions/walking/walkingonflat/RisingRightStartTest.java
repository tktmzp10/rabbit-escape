package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_RISING_RIGHT_START;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class RisingRightStartTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private RisingRightStart risingRightStart = new RisingRightStart();

    @Test
    public void getState() {
        assertEquals(RABBIT_RISING_RIGHT_START, risingRightStart.getState());
    }

    @Test
    public void behave() {
        assertTrue(risingRightStart.behave(world, character));
    }
}