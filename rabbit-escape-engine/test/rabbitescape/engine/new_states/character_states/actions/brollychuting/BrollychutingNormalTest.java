package rabbitescape.engine.new_states.character_states.actions.brollychuting;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BROLLYCHUTING;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BrollychutingNormalTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private BrollychutingNormal brollychutingNormal = new BrollychutingNormal();

    @Test
    public void newState() {
        assertEquals(RABBIT_BROLLYCHUTING, brollychutingNormal.getState());
    }

    @Test
    public void behave() {
        assertTrue(brollychutingNormal.behave(world, character));
    }
}