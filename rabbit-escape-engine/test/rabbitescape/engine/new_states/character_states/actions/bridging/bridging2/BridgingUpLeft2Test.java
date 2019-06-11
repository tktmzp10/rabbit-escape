package rabbitescape.engine.new_states.character_states.actions.bridging.bridging2;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_BRIDGING_UP_LEFT_2;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class BridgingUpLeft2Test {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private static Bridging bridging = new Bridging();
    private BridgingUpLeft2 bridgingUpLeft2 = new BridgingUpLeft2();

    @Test
    public void getState() {
        assertEquals(RABBIT_BRIDGING_UP_LEFT_2, bridgingUpLeft2.getState());
    }

    @Test
    public void behave() {
        assertTrue(bridgingUpLeft2.behave(world, character, bridging));
    }
}