package rabbitescape.engine.new_states.character_states.actions.bridging.bridging3;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_DOWN_UP_LEFT_3;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.new_states.character_states.actions.bridging.bridging2.BridgingDownUpLeft2;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingDownUpLeft3Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Bridging bridging = new Bridging();
    private BridgingDownUpLeft3 bridgingDownUpLeft3 = new BridgingDownUpLeft3();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_DOWN_UP_LEFT_3, bridgingDownUpLeft3.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingDownUpLeft3.behave(world, character, bridging));
    }
}