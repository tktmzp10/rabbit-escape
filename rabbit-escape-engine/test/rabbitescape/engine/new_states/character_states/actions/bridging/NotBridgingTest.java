package rabbitescape.engine.new_states.character_states.actions.bridging;

import static org.junit.Assert.*;
import static rabbitescape.engine.Direction.RIGHT;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Bridging;
import rabbitescape.engine.new_states.character_states.actions.bridging.bridging3.BridgingDownUpLeft3;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.things.characters.Rabbit;

public class NotBridgingTest {

    private World world = TextWorldManip.createEmptyWorld(3, 4);
    private Character character = new Rabbit(1, 1, RIGHT);
    private Bridging bridging = new Bridging();
    private NotBridging notBridging = new NotBridging();

    @Test
    public void getState() {
        assertNull(notBridging.getState());
    }

    @Test
    public void behave() {
        assertFalse(notBridging.behave(world, character, bridging));
    }
}