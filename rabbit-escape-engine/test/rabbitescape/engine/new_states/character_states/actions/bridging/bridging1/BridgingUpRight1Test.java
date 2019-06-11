package rabbitescape.engine.new_states.character_states.actions.bridging.bridging1;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_UP_RIGHT_1;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.new_states.character_states.actions.bashing.BashingUpRight;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingUpRight1Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingUpRight1 bridgingUpRight1 = new BridgingUpRight1();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_UP_RIGHT_1, bridgingUpRight1.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingUpRight1.behave(world, character, bridging));
    }
}