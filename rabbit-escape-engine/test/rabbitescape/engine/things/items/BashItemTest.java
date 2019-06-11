package rabbitescape.engine.things.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static rabbitescape.engine.ChangeDescription.State.TOKEN_BASH_FALLING;
import static rabbitescape.engine.ChangeDescription.State.TOKEN_BASH_FALL_TO_SLOPE;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Item;
import rabbitescape.engine.things.ItemTest;

public class BashItemTest {

    public static final int X = 10;
    public static final int Y = 20;
    public static final char CHARACTER_REPRESENT = 'b';
    public static final String TYPE_NAME = "bash";
    public static final State FALLING = TOKEN_BASH_FALLING;
    public static final State FALL_TO_SLOPE = TOKEN_BASH_FALL_TO_SLOPE;
    private BashItem item;
    private BashItem itemWithWorld;
    private World emptyWorld = TextWorldManip.createEmptyWorld(100, 100);

    @Before
    public void setUp() {
        item = new BashItem(X, Y);
        itemWithWorld = new BashItem(X, Y, emptyWorld);
    }

    @Test
    public void getCharRepresentation() {
        assertEquals(CHARACTER_REPRESENT, item.getCharRepresentation());
        assertEquals(CHARACTER_REPRESENT, itemWithWorld.getCharRepresentation());
    }

    @Test
    public void copyWithoutState() {
        Item copy1 = item.copyWithoutState();
        Item copy2 = itemWithWorld.copyWithoutState();

        assertTrue(ItemTest.isEqual(copy1, copy2));
    }

    @Test
    public void getType() {
        assertEquals(BashItem.TYPE, item.getType());
        assertEquals(BashItem.TYPE, itemWithWorld.getType());
    }

    @Test
    public void calcNewSate() {
        item.calcNewState(emptyWorld);
        assertEquals(FALLING, item.state);
    }

    @Test
    public void step() {
        assertEquals(Y, item.y);
        item.step(emptyWorld);
        assertEquals(Y + 1, item.y);

        assertEquals(Y, itemWithWorld.y);
        itemWithWorld.step(emptyWorld);
        assertEquals(Y + 1, itemWithWorld.y);
    }

    @Test
    public void stepOutsideWorld() {
        item.y = emptyWorld.size.height;
        item.step(emptyWorld);
        assertTrue(item.y >= emptyWorld.size.height);

        itemWithWorld.y = emptyWorld.size.height;
        itemWithWorld.step(emptyWorld);
        assertTrue(itemWithWorld.y >= emptyWorld.size.height);
    }

    @Test
    public void saveState() {
        final Map<String, String> map = item.saveState(false);
        final Map<String, String> mapWithWorld = itemWithWorld.saveState(false);

        assertTrue(map instanceof HashMap);
        assertTrue(map.isEmpty());

        assertTrue(mapWithWorld instanceof HashMap);
        assertTrue(mapWithWorld.isEmpty());
    }

    @Test
    public void restoreFromState() {
        item.restoreFromState(null);
        assertEquals(FALL_TO_SLOPE, item.state);

        itemWithWorld.restoreFromState(null);
        assertEquals(FALLING, itemWithWorld.state);
    }

    @Test
    public void overlayText() {
        assertEquals(TYPE_NAME, item.overlayText());
        assertEquals(TYPE_NAME, itemWithWorld.overlayText());
    }
}
