package rabbitescape.engine.new_states.character_states.actions.digging;

import static org.junit.Assert.*;
import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.FLAT;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_DIGGING_ON_SLOPE;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.Block;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class DiggingOnSlopeTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private DiggingOnSlope diggingOnSlope = new DiggingOnSlope();

    @Test
    public void newState() {
        assertEquals(RABBIT_DIGGING_ON_SLOPE, diggingOnSlope.getState());
    }

    @Test
    public void behave() {
        world.blockTable.add(new Block(1, 1, EARTH, FLAT, 4));
        assertTrue(diggingOnSlope.behave(world, character));
    }
}