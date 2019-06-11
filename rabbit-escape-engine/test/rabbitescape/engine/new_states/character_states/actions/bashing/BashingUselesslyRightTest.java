package rabbitescape.engine.new_states.character_states.actions.bashing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BashingUselesslyRightTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static BashingUselesslyRight bashingUselesslyRight = new BashingUselesslyRight();

    @Test
    public void getState() {
        assertNotNull(bashingUselesslyRight.getState());
    }

    @Test
    public void behave() {
        assertTrue(bashingUselesslyRight.behave(world, character));
    }
}