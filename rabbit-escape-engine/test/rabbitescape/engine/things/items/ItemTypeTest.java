package rabbitescape.engine.things.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTypeTest {

    @Test
    public void name() {
        assertEquals("Bash", ItemType.name(ItemType.bash));
        assertEquals("Dig", ItemType.name(ItemType.dig));
        assertEquals("Bridge", ItemType.name(ItemType.bridge));
        assertEquals("Block", ItemType.name(ItemType.block));
        assertEquals("Climb", ItemType.name(ItemType.climb));
        assertEquals("Explode", ItemType.name(ItemType.explode));
        assertEquals("Brolly", ItemType.name(ItemType.brolly));
    }
}
