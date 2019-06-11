package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_LEFT_END;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class LoweringLeftEndTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private LoweringLeftEnd loweringLeftEnd = new LoweringLeftEnd();

    @Test
    public void getState() {
        assertEquals(RABBIT_LOWERING_LEFT_END, loweringLeftEnd.getState());
    }

    @Test
    public void behave() {
        assertTrue(loweringLeftEnd.behave(world, character));
    }
}