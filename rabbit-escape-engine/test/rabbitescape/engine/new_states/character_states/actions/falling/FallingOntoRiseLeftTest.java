package rabbitescape.engine.new_states.character_states.actions.falling;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_ONTO_RISE_LEFT;
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

public class FallingOntoRiseLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Climbing climbing = new Climbing();
    private Digging digging = new Digging();
    private Brollychuting brollychuting = new Brollychuting(climbing, digging);
    private Falling falling = new Falling(climbing, brollychuting, 4);
    private static FallingOntoRiseLeft fallingOntoRiseLeft = new FallingOntoRiseLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_FALLING_ONTO_RISE_LEFT, fallingOntoRiseLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(fallingOntoRiseLeft.behave(world, character, falling));
    }
}