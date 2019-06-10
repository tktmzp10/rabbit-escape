package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.newstates.ItemState;
import rabbitescape.engine.newstates.item_states.dig.DigFallToSlope;
import rabbitescape.engine.things.Item;

public class DigItem extends Item {

    public static final ItemType TYPE = ItemType.dig;
    public static final ItemState DEFAULT_STATE = new DigFallToSlope();

    public DigItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public DigItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'd';
    }

    @Override
    public Item copyWithoutState() {
        return new DigItem(this.x, this.y);
    }
}
