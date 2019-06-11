package rabbitescape.engine.new_states.character_states.actions.falling;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Brollychuting;
import rabbitescape.engine.new_states.character_states.actions.Climbing;
import rabbitescape.engine.new_states.character_states.actions.Digging;
import rabbitescape.engine.new_states.character_states.actions.Falling;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class DyingOfFalling2SlopeRiseLeft2Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Climbing climbing = new Climbing();
    private Digging digging = new Digging();
    private Brollychuting brollychuting = new Brollychuting(climbing, digging);
    private Falling falling = new Falling(climbing, brollychuting, 4);
    private static DyingOfFalling2SlopeRiseLeft2 dyingOfFalling2SlopeRiseLeft2 = new DyingOfFalling2SlopeRiseLeft2();

    @Test
    public void getState() {
        assertEquals(RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT_2, dyingOfFalling2SlopeRiseLeft2.getState());
    }

    @Test
    public void behave() {
        assertTrue(dyingOfFalling2SlopeRiseLeft2.behave(world, character, falling));
    }
}