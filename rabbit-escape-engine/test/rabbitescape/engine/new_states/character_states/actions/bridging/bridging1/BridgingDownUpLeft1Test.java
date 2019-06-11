package rabbitescape.engine.new_states.character_states.actions.bridging.bridging1;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_DOWN_UP_LEFT_1;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.new_states.character_states.actions.bashing.BashingLeft;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingDownUpLeft1Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingDownUpLeft1 bridgingDownUpLeft1 = new BridgingDownUpLeft1();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_DOWN_UP_LEFT_1, bridgingDownUpLeft1.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingDownUpLeft1.behave(world, character, bridging));
    }
}