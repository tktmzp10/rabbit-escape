package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.newstates.ItemState;
import rabbitescape.engine.newstates.item_states.bridge.BridgeFallToSlope;
import rabbitescape.engine.things.Item;

public class BridgeItem extends Item {

    public static final ItemType TYPE = ItemType.bridge;
    public static final ItemState DEFAULT_STATE = new BridgeFallToSlope();

    public BridgeItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public BridgeItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'i';
    }

    @Override
    public Item copyWithoutState() {
        return new BridgeItem(this.x, this.y);
    }
}
