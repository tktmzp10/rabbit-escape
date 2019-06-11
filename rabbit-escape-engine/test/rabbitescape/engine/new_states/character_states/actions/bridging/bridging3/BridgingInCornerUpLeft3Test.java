package rabbitescape.engine.new_states.character_states.actions.bridging.bridging3;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_UP_LEFT_3;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingInCornerUpLeft3Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Bridging bridging = new Bridging();
    private BridgingInCornerUpLeft3 bridgingInCornerUpLeft3 = new BridgingInCornerUpLeft3();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_IN_CORNER_UP_LEFT_3, bridgingInCornerUpLeft3.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingInCornerUpLeft3.behave(world, character, bridging));
    }
}