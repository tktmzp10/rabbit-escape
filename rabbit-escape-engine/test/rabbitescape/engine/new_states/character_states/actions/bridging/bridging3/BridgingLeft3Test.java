package rabbitescape.engine.new_states.character_states.actions.bridging.bridging3;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_LEFT_3;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingLeft3Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Bridging bridging = new Bridging();
    private BridgingLeft3 bridgingLeft3 = new BridgingLeft3();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_LEFT_3, bridgingLeft3.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingLeft3.behave(world, character, bridging));
    }
}