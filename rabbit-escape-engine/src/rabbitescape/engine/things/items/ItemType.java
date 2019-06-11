package rabbitescape.engine.things.items;

public enum ItemType {
    empty,
    bash,
    dig,
    bridge,
    block,
    climb,
    explode,
    brolly;

    public static String name(ItemType ability) {
        String n = ability.name();
        return n.substring(0, 1).toUpperCase() + n.substring(1);
    }
}
