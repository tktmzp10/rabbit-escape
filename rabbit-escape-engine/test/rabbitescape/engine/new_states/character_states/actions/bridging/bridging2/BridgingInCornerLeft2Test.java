package rabbitescape.engine.new_states.character_states.actions.bridging.bridging2;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_IN_CORNER_LEFT_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingInCornerLeft2Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingInCornerLeft2 bridgingInCornerLeft2 = new BridgingInCornerLeft2();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_IN_CORNER_LEFT_2, bridgingInCornerLeft2.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingInCornerLeft2.behave(world, character, bridging));
    }
}