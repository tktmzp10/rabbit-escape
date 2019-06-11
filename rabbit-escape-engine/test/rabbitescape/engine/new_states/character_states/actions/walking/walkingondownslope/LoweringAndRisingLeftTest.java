package rabbitescape.engine.new_states.character_states.actions.walking.walkingondownslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_LOWERING_AND_RISING_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Walking;
import rabbitescape.engine.new_states.character_states.actions.waiting.NotWaiting;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class LoweringAndRisingLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private LoweringAndRisingLeft loweringAndRisingLeft = new LoweringAndRisingLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_LOWERING_AND_RISING_LEFT, loweringAndRisingLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(loweringAndRisingLeft.behave(world, character));
    }
}