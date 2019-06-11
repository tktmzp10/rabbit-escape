package rabbitescape.engine.new_states.character_states.actions.walking.walkingonupslope;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_RISING_AND_LOWERING_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat.LoweringLeftStart;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class RisingAndLoweringLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private RisingAndLoweringLeft risingAndLoweringLeft = new RisingAndLoweringLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_RISING_AND_LOWERING_LEFT, risingAndLoweringLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(risingAndLoweringLeft.behave(world, character));
    }
}