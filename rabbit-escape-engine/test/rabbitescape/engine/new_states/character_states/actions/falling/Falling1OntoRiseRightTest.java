package rabbitescape.engine.new_states.character_states.actions.falling;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_FALLING_1_ONTO_RISE_RIGHT;
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

public class Falling1OntoRiseRightTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Climbing climbing = new Climbing();
    private Digging digging = new Digging();
    private Brollychuting brollychuting = new Brollychuting(climbing, digging);
    private Falling falling = new Falling(climbing, brollychuting, 4);
    private static Falling1OntoRiseRight falling1OntoRiseRight = new Falling1OntoRiseRight();

    @Test
    public void getState() {
        assertEquals(RABBIT_FALLING_1_ONTO_RISE_RIGHT, falling1OntoRiseRight.getState());
    }

    @Test
    public void behave() {
        assertTrue(falling1OntoRiseRight.behave(world, character, falling));
    }
}