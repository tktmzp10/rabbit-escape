package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_WALKING_RIGHT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.waiting.WaitingRight;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class WalkingRightTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private WalkingRight walkingRight = new WalkingRight();

    @Test
    public void getState() {
        assertEquals(RABBIT_WALKING_RIGHT, walkingRight.getState());
    }

    @Test
    public void behave() {
        assertTrue(walkingRight.behave(world, character));
    }
}