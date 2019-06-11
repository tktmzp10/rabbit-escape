package rabbitescape.engine.new_states.character_states.actions.crashing;

import static org.junit.Assert.*;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class NotCrashingTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private NotCrashing notCrashing = new NotCrashing();

    @Test
    public void newState() {
        assertNull(notCrashing.getState());
    }

    @Test
    public void behave() {
        assertFalse(notCrashing.behave(world, character));
    }
}