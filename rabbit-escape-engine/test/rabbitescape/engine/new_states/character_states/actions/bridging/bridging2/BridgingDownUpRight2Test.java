package rabbitescape.engine.new_states.character_states.actions.bridging.bridging2;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_DOWN_UP_RIGHT_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingDownUpRight2Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingDownUpRight2 bridgingDownUpRight2 = new BridgingDownUpRight2();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_DOWN_UP_RIGHT_2, bridgingDownUpRight2.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingDownUpRight2.behave(world, character, bridging));
    }
}