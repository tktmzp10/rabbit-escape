package rabbitescape.engine.new_states.character_states.actions.bashing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Block.Shape.FLAT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.Block;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BashingRightTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static BashingRight bashingRight = new BashingRight();

    @Test
    public void getState() {
        assertNotNull(bashingRight.getState());
    }

    @Test
    public void behave() {
        world.blockTable.add(new Block(2, 1, EARTH, FLAT, 4));
        assertTrue(bashingRight.behave(world, character));
    }
}