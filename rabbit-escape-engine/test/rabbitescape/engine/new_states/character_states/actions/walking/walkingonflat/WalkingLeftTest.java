package rabbitescape.engine.new_states.character_states.actions.walking.walkingonflat;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_WALKING_LEFT;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class WalkingLeftTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private WalkingLeft walkingLeft = new WalkingLeft();

    @Test
    public void getState() {
        assertEquals(RABBIT_WALKING_LEFT, walkingLeft.getState());
    }

    @Test
    public void behave() {
        assertTrue(walkingLeft.behave(world, character));
    }
}