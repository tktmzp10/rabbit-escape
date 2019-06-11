package rabbitescape.engine.things.items;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;
import rabbitescape.engine.World;
import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.Item;
import rabbitescape.engine.things.ItemTest;

public class ItemFactoryTest {

    public static final int X = 10;
    public static final int Y = 20;
    private World emptyWorld = TextWorldManip.createEmptyWorld(100, 100);

    @Test
    public void createItem() {
        Item bash = ItemFactory.createItem(X, Y, BashItem.TYPE);
        Item dig = ItemFactory.createItem(X, Y, DigItem.TYPE);
        Item bridge = ItemFactory.createItem(X, Y, BridgeItem.TYPE);
        Item block = ItemFactory.createItem(X, Y, BlockItem.TYPE);
        Item climb = ItemFactory.createItem(X, Y, ClimbItem.TYPE);
        Item explode = ItemFactory.createItem(X, Y, ExplodeItem.TYPE);
        Item brolly = ItemFactory.createItem(X, Y, BrollyItem.TYPE);

        assertTrue(ItemTest.isEqual(new BashItem(X, Y), bash));
        assertTrue(ItemTest.isEqual(new DigItem(X, Y), dig));
        assertTrue(ItemTest.isEqual(new BridgeItem(X, Y), bridge));
        assertTrue(ItemTest.isEqual(new BlockItem(X, Y), block));
        assertTrue(ItemTest.isEqual(new ClimbItem(X, Y), climb));
        assertTrue(ItemTest.isEqual(new ExplodeItem(X, Y), explode));
        assertTrue(ItemTest.isEqual(new BrollyItem(X, Y), brolly));
    }

    @Test(expected = UnknownItemTypeException.class)
    public void createEmptyItem() {
        ItemFactory.createItem(X, Y, ItemType.empty);
    }

    @Test
    public void createItemWithWorld() {
        Item bash = ItemFactory.createItem(X, Y, BashItem.TYPE, emptyWorld);
        Item dig = ItemFactory.createItem(X, Y, DigItem.TYPE, emptyWorld);
        Item bridge = ItemFactory.createItem(X, Y, BridgeItem.TYPE, emptyWorld);
        Item block = ItemFactory.createItem(X, Y, BlockItem.TYPE, emptyWorld);
        Item climb = ItemFactory.createItem(X, Y, ClimbItem.TYPE, emptyWorld);
        Item explode = ItemFactory.createItem(X, Y, ExplodeItem.TYPE, emptyWorld);
        Item brolly = ItemFactory.createItem(X, Y, BrollyItem.TYPE, emptyWorld);

        assertTrue(ItemTest.isEqual(new BashItem(X, Y, emptyWorld), bash));
        assertTrue(ItemTest.isEqual(new DigItem(X, Y, emptyWorld), dig));
        assertTrue(ItemTest.isEqual(new BridgeItem(X, Y, emptyWorld), bridge));
        assertTrue(ItemTest.isEqual(new BlockItem(X, Y, emptyWorld), block));
        assertTrue(ItemTest.isEqual(new ClimbItem(X, Y, emptyWorld), climb));
        assertTrue(ItemTest.isEqual(new ExplodeItem(X, Y, emptyWorld), explode));
        assertTrue(ItemTest.isEqual(new BrollyItem(X, Y, emptyWorld), brolly));
    }

    @Test(expected = UnknownItemTypeException.class)
    public void createEmptyItemWithWorld() {
        ItemFactory.createItem(X, Y, ItemType.empty, emptyWorld);
    }

    @Test
    public void createItemByCharacter() {
        Item bash = ItemFactory.createItem(X, Y, 'b');
        Item dig = ItemFactory.createItem(X, Y, 'd');
        Item bridge = ItemFactory.createItem(X, Y, 'i');
        Item block = ItemFactory.createItem(X, Y, 'k');
        Item climb = ItemFactory.createItem(X, Y, 'c');
        Item explode = ItemFactory.createItem(X, Y, 'p');
        Item brolly = ItemFactory.createItem(X, Y, 'l');

        assertTrue(ItemTest.isEqual(new BashItem(X, Y), bash));
        assertTrue(ItemTest.isEqual(new DigItem(X, Y), dig));
        assertTrue(ItemTest.isEqual(new BridgeItem(X, Y), bridge));
        assertTrue(ItemTest.isEqual(new BlockItem(X, Y), block));
        assertTrue(ItemTest.isEqual(new ClimbItem(X, Y), climb));
        assertTrue(ItemTest.isEqual(new ExplodeItem(X, Y), explode));
        assertTrue(ItemTest.isEqual(new BrollyItem(X, Y), brolly));
    }

    @Test(expected = UnknownCharRepresentationException.class)
    public void invalidType() {
        ItemFactory.createItem(X, Y, 'z');
    }
}
