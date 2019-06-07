package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.newstates.item_states.ItemState;
import rabbitescape.engine.newstates.item_states.block.BlockFallToSlope;
import rabbitescape.engine.things.Item;

public class BlockItem extends Item {

    public static final ItemType TYPE = ItemType.block;
    public static final ItemState DEFAULT_STATE = new BlockFallToSlope();

    public BlockItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public BlockItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'k';
    }

    @Override
    public Item copyWithoutState() {
        return new BlockItem(this.x, this.y);
    }
}
