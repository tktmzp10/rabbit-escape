package rabbitescape.engine.new_states.character_states.actions.bridging.bridging2;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingInCornerUpRight2Test {
    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingInCornerUpRight2 bridgingInCornerUpRight2 = new BridgingInCornerUpRight2();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_2, bridgingInCornerUpRight2.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingInCornerUpRight2.behave(world, character, bridging));
    }
}