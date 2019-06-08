package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.newstates.item_states.ItemState;
import rabbitescape.engine.newstates.item_states.bash.BashFallToSlope;
import rabbitescape.engine.things.Item;

public class BashItem extends Item {

    public static final ItemType TYPE = ItemType.bash;
    public static final ItemState DEFAULT_STATE = new BashFallToSlope();

    public BashItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public BashItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'b';
    }

    @Override
    public Item copyWithoutState() {
        return new BashItem(this.x, this.y);
    }
}
