package rabbitescape.engine.things.items;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Item;

public class DigItem extends Item {

    private static final ItemType type = ItemType.dig;

    public DigItem(int x, int y) {
        super(x, y, State.TOKEN_DIG_FALL_TO_SLOPE, type);
    }

    public DigItem(int x, int y, World world) {
        super(x, y, State.TOKEN_DIG_FALL_TO_SLOPE, type, world);
    }

    @Override
    public char getCharRepresentation() {
        return 'd';
    }

    @Override
    public State getStillState() {
        return State.TOKEN_DIG_STILL;
    }

    @Override
    public State getFallingState() {
        return State.TOKEN_DIG_FALLING;
    }

    @Override
    public State getFallToSlopState() {
        return State.TOKEN_DIG_FALL_TO_SLOPE;
    }

    @Override
    public State getOnSlopeState() {
        return State.TOKEN_DIG_ON_SLOPE;
    }

    @Override
    public Item copyWithoutState() {
        return new DigItem(this.x, this.y);
    }
}
