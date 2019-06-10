package rabbitescape.engine.things;

import java.util.HashMap;
import java.util.Map;
import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.BridgeTools;
import rabbitescape.engine.Thing;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.item_states.ItemState;
import rabbitescape.engine.things.items.ItemType;

public abstract class Item extends Thing {

    private final ItemType type;
    private ItemState itemState;

    public Item(int x, int y, ItemState itemState, ItemType type) {
        super(x, y, itemState);
        this.type = type;
        this.itemState = itemState;
    }

    public Item(int x, int y, ItemState itemState, ItemType type, World world) {
        this(x, y, itemState, type);
        boolean onSlope = BehaviourTools.isSlope(world.getBlockAt(x, y));
        // Can't use calcNewState here since we have just been created, so
        // can't be moving (until a time step passes).
        this.itemState = itemState.newState();

        // @TODO must remove state enum
        this.state = this.itemState.getState();
    }

    public ItemType getType() {
        return type;
    }

    public abstract Item copyWithoutState();

    public abstract char getCharRepresentation();

    @Override
    public void calcNewState(World world) {
        Block onBlock = world.getBlockAt(x, y);
        Block belowBlock = world.getBlockAt(x, y + 1);
        boolean still = BehaviourTools.s_isFlat(belowBlock) || (onBlock != null) || BridgeTools
            .someoneIsBridgingAt(world, x, y);

        itemState.setMoving(!still);
        itemState.setSlopeBelow(BehaviourTools.isSlope(belowBlock));
        itemState.setOnSlope(BehaviourTools.isSlope(onBlock));
        itemState = itemState.newState();

        // @TODO must remove state enum
        state = itemState.getState();
    }

    @Override
    public void step(World world) {
        if (itemState.isFalling()) {
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
