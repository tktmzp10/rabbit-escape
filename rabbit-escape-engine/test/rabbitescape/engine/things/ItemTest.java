package rabbitescape.engine.things;

public class ItemTest {

    public static boolean isEqual(Item item1, Item item2) {
        return item1.x == item2.x && item1.y == item2.y;
    }
}
