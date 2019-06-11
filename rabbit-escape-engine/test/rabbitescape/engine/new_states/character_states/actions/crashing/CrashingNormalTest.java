package rabbitescape.engine.new_states.character_states.actions.crashing;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_CRASHING;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class CrashingNormalTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private CrashingNormal crashingNormal = new CrashingNormal();

    @Test
    public void newState() {
        assertEquals(RABBIT_CRASHING, crashingNormal.getState());
    }

    @Test
    public void behave() {
        assertTrue(crashingNormal.behave(world, character));
    }
}