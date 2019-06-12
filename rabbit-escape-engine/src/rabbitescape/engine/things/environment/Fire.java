package rabbitescape.engine.things.environment;

import static rabbitescape.engine.BridgeTools.someoneIsBridgingAt;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Thing;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.environment_states.FireStates;
import rabbitescape.engine.new_states.environment_states.fire_states.FireExtinguishing;

public abstract class Fire extends Thing {

    public FireStates fireState;
    public int variant;

    private final State baseVariant;

    public Fire(int x, int y, State state) {
        super(x, y, state);
        baseVariant = state;
    }

    public void setFireState(FireStates fireState) {
        this.fireState = fireState;
        state = fireState.getState();
    }

    @Override
    public void calcNewState(World world) {

        if (isFireExtinguished(world)) {
            setFireState(new FireExtinguishing());
            return;
        }

        Block blockBelow = world.getBlockAt(x, y + 1);
        boolean flatBelow = BehaviourTools.s_isFlat(blockBelow);

        if (isStill(world, flatBelow)) {
            calcNewStateOnFlatGround(world, flatBelow);
        } else // Falling
        {
            calcNewStateWhenFalling(blockBelow);
        }
    }

    private void calcNewStateWhenFalling(Block blockBelow) {
        if (BehaviourTools.isLeftRiseSlope(blockBelow)) {
            changeStateFallToRiseLeft();
        } else if (BehaviourTools.isRightRiseSlope(blockBelow)) {
            changeStateFallToRiseRight();
        }
        changeStateFalling();
    }

    private void calcNewStateOnFlatGround(World world, boolean flatBelow) {
        Block onBlock = world.getBlockAt(x, y);
        if (BehaviourTools.isLeftRiseSlope(onBlock)) {
            changeStateRiseLeft();
        } else if (BehaviourTools.isRightRiseSlope(onBlock)) {
            changeStateRiseRight();
        } else if (flatBelow) {
            state = baseVariant;
        }
    }

    private boolean isFireExtinguished(World world) {
        boolean extinguished = false;

        for (WaterRegion waterRegion : world.waterTable.getItemsAt(x, y)) {
            final boolean isWaterExisting = waterRegion.getContents() > 0;
			if (isWaterExisting) {
				extinguished = true;
            }
        }
        return extinguished;
    }

    public abstract void changeStateRiseLeft();

    public abstract void changeStateRiseRight();

    public abstract void changeStateFalling();

    public abstract void changeStateFallToRiseRight();

    public abstract void changeStateFallToRiseLeft();

    private boolean isStill(World world, boolean flatBelow) {
        return flatBelow
            || (world.getBlockAt(x, y) != null)
            || someoneIsBridgingAt(world, x, y);
    }

    @Override
    public void step(World world) {
        fireState.step(world, this);
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
        return "Fire";
    }
}
