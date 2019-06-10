package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.new_states.ItemState;
import rabbitescape.engine.new_states.item_states.explode.ExplodeFallToSlope;
import rabbitescape.engine.things.Item;

public class ExplodeItem extends Item {

    public static final ItemType TYPE = ItemType.explode;
    public static final ItemState DEFAULT_STATE = new ExplodeFallToSlope();

    public ExplodeItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public ExplodeItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'p';
    }

    @Override
    public Item copyWithoutState() {
        return new ExplodeItem(this.x, this.y);
    }
}
