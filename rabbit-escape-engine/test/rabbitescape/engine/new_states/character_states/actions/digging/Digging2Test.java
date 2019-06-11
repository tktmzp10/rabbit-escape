package rabbitescape.engine.new_states.character_states.actions.digging;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_DIGGING_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class Digging2Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Digging2 digging2 = new Digging2();

    @Test
    public void newState() {
        assertEquals(RABBIT_DIGGING_2, digging2.getState());
    }

    @Test
    public void behave() {
        assertTrue(digging2.behave(world, character));
    }
}