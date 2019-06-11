package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_RIGHT_END;
import static rabbitescape.engine.Direction.RIGHT;

import com.sun.org.apache.bcel.internal.generic.LREM;
import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class LoweringRightEndTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private LoweringRightEnd loweringRightEnd = new LoweringRightEnd();

    @Test
    public void getState() {
        assertEquals(RABBIT_LOWERING_RIGHT_END, loweringRightEnd.getState());
    }

    @Test
    public void behave() {
        assertTrue(loweringRightEnd.behave(world, character));
    }
}