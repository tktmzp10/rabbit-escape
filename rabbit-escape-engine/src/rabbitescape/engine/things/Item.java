package rabbitescape.engine.things;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.things.items.ItemType;

import java.util.HashMap;
import java.util.Map;

public abstract class Item extends Thing {

    private final ItemType type;

    public Item(int x, int y, State state, ItemType type) {
        super(x, y, state);
        this.type = type;
    }

    public Item(int x, int y, State state, ItemType type, World world) {
        this(x, y, state, type);
        boolean onSlope = BehaviourTools.isSlope(world.getBlockAt(x, y));
        // Can't use calcNewState here since we have just been created, so
        // can't be moving (until a time step passes).
        this.state = chooseState(false, false, onSlope);
    }

    public ItemType getType() {
        return type;
    }

    public abstract Item copyWithoutState();

    public abstract char getCharRepresentation();

    public abstract State getStillState();

    public abstract State getFallingState();

    public abstract State getFallToSlopState();

    public abstract State getOnSlopeState();

    protected State chooseState(
        boolean moving, boolean slopeBelow, boolean onSlope
    ) {
        if (onSlope) {
            return getOnSlopeState();
        }
        if (!moving) {
            return getStillState();
        }
        if (slopeBelow) {
            return getFallToSlopState();
        }
        return getFallingState();
    }

    @Override
    public void calcNewState(World world) {
        Block onBlock = world.getBlockAt(x, y);
        Block belowBlock = world.getBlockAt(x, y + 1);
        boolean still = (
            BehaviourTools.s_isFlat(belowBlock)
                || (onBlock != null)
                || BridgeTools.someoneIsBridgingAt(world, x, y)
        );

        state = chooseState(!still, BehaviourTools.isSlope(belowBlock),
            BehaviourTools.isSlope(onBlock)
        );
    }

    @Override
    public void step(World world) {
        if (state == getFallingState() || state == getFallToSlopState()) {
            y++;

            if (y >= world.size.height) {
                world.changes.removeToken(this);
            }
        }
    }

    @Override
    public Map<String, String> saveState(boolean runtimeMeta) {
        return new HashMap<String, String>();
    }

    @Override
    public void restoreFromState(Map<String, String> state) {
    }

    @Override
    public String overlayText() {
        return type.toString();
    }
}
