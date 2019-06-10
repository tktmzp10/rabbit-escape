package rabbitescape.engine.things.items;

import rabbitescape.engine.World;
import rabbitescape.engine.new_states.ItemState;
import rabbitescape.engine.new_states.item_states.climb.ClimbFallToSlope;
import rabbitescape.engine.things.Item;

public class ClimbItem extends Item {

    public static final ItemType TYPE = ItemType.climb;
    public static final ItemState DEFAULT_STATE = new ClimbFallToSlope();

    public ClimbItem(int x, int y) {
        super(x, y, DEFAULT_STATE, TYPE);
    }

    public ClimbItem(int x, int y, World world) {
        super(x, y, DEFAULT_STATE, TYPE, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'c';
    }

    @Override
    public Item copyWithoutState() {
        return new ClimbItem(this.x, this.y);
    }
}
