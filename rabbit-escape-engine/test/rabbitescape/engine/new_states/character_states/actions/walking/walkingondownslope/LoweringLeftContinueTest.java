package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_LEFT_CONTINUE;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class LoweringLeftContinueTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private LoweringLeftContinue loweringLeftContinue = new LoweringLeftContinue();

    @Test
    public void getState() {
        assertEquals(RABBIT_LOWERING_LEFT_CONTINUE, loweringLeftContinue.getState());
    }

    @Test
    public void behave() {
        assertTrue(loweringLeftContinue.behave(world, character));
    }
}