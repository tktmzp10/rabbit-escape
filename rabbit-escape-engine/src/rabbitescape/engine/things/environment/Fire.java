package rabbitescape.engine.things.environment;

import static rabbitescape.engine.BridgeTools.someoneIsBridgingAt;
import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.Block;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.Thing;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.EnvironmentStates;
import rabbitescape.engine.newstates.environment_states.fire_states.FireExtinguishing;
import rabbitescape.engine.things.environment.fire.Fire_A;
import rabbitescape.engine.things.environment.fire.Fire_B;
import rabbitescape.engine.things.environment.fire.Fire_C;
import rabbitescape.engine.things.environment.fire.Fire_D;

public abstract class Fire extends Thing {

    public EnvironmentStates environmentState;
    public int variant;

    private final State baseVariant;

    public Fire(int x, int y, State state) {
        super(x, y, state);
        baseVariant = state;
    }

    public void setEnvironmentState(EnvironmentStates environmentState) {
        this.environmentState = environmentState;
        state = environmentState.getState();
    }

    @Override
    public void calcNewState(World world) {

        if (isFireExtinguished(world)) {
            setEnvironmentState(new FireExtinguishing());
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
            if (waterRegion.getContents() > 0) {
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
        switch (state) {
            case FIRE_A_FALLING:
            case FIRE_B_FALLING:
            case FIRE_C_FALLING:
            case FIRE_D_FALLING:
            case FIRE_A_FALL_TO_RISE_RIGHT:
            case FIRE_B_FALL_TO_RISE_RIGHT:
            case FIRE_C_FALL_TO_RISE_RIGHT:
            case FIRE_D_FALL_TO_RISE_RIGHT:
            case FIRE_A_FALL_TO_RISE_LEFT:
            case FIRE_B_FALL_TO_RISE_LEFT:
            case FIRE_C_FALL_TO_RISE_LEFT:
            case FIRE_D_FALL_TO_RISE_LEFT:
                ++y;
                if (y >= world.size.height) {
                    world.changes.removeFire(this);
                }
                return;
            case FIRE_EXTINGUISHING:
                world.changes.removeFire(this);
                return;
            default:
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
        return "Fire";
    }
}
