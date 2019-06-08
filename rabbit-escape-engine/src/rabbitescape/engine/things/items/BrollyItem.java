package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.newstates.item_states.ItemState;
import rabbitescape.engine.newstates.item_states.brolly.BrollyFallToSlope;
import rabbitescape.engine.things.Item;

public class BrollyItem extends Item {

    public static final ItemType TYPE = ItemType.brolly;
    public static final ItemState DEFAULT_STATE = new BrollyFallToSlope();

    public BrollyItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public BrollyItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'l';
    }

    @Override
    public Item copyWithoutState() {
        return new BrollyItem(this.x, this.y);
    }
}
