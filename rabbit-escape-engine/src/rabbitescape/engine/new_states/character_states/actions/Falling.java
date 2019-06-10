package rabbitescape.engine.new_states.character_states.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Block.Shape.*;
import static rabbitescape.engine.Direction.RIGHT;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.character_states.CharacterActionStates;
import rabbitescape.engine.new_states.character_states.actions.falling.*;
import rabbitescape.engine.things.Character;

public class Falling extends CharacterActionStates {

    private IFallingState fallingState;
    public int heightFallen = 0;

    private final Climbing climbing;
    private final Brollychuting brollychuting;
    private final int fatalHeight;

    public Falling(
        Climbing climbing,
        Brollychuting brollychuting,
        int fatalHeight
    ) {
        this.climbing = climbing;
        this.brollychuting = brollychuting;
        this.fatalHeight = fatalHeight;
        setFallingState(new NotFalling());
    }

    public void setFallingState(IFallingState fallingState) {
        this.fallingState = fallingState;
    }

    public void setFallingState(
        IFallingState right,
        IFallingState left,
        Character character
    ) {
        if (character.dir == RIGHT) {
            setFallingState(right);
        } else {
            setFallingState(left);
        }
    }

    public boolean isFallingToDeath() {
        return heightFallen > fatalHeight;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        if (climbing.abilityActive
            || character.state == RABBIT_DIGGING
            || brollychuting.hasBrolly()) {
            return false;
        }

        BehaviourTools t = new BehaviourTools(character, world);

        //noinspection RedundantIfStatement
        if (t.isFlat(t.blockBelow())) {
            return false;
        }

        if (
            character.onSlope
                && !t.blockHereJustRemoved()
        ) {
            return false;
        }

        return true;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (newStateWhenDefiniteNext(t)) {
            return fallingState.getState();
        }

        if (!triggered) {
            return newStateWhenNotTriggered();
        }

        if (
            // Going to die
            (heightFallen + 1 > fatalHeight)
                // during step
                && (t.isFlat(t.block2Below()) || t.blockBelow() != null)
        ) {
            return newStateWhenFatal(t);
        } else {
            Block below = t.blockBelow();
            if (newStateWhenBlockBelow(t, below)) {
                return fallingState.getState();
            }

            Block twoBelow = t.block2Below();
            return newStateWhenBlockBelowTwo(t, twoBelow);
        }
    }

    private boolean newStateWhenDefiniteNext(BehaviourTools t) {
        if (RABBIT_DYING_OF_FALLING_SLOPE_RISE_LEFT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFallingSlopeRiseLeft2());
            return true;
        }

        if (RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFalling2SlopeRiseLeft2());
            return true;
        }

        if (RABBIT_DYING_OF_FALLING_SLOPE_RISE_RIGHT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFallingSlopeRiseRight2());
            return true;
        }

        if (RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT == t.character.state) {
            setFallingState(new DyingOfFalling2SlopeRiseRight2());
            return true;
        }
        return false;
    }

    private State newStateWhenBlockBelowTwo(BehaviourTools t, Block twoBelow) {
        if (twoBelow != null) {
            if (heightFallen + 1 > fatalHeight
                && BehaviourTools.isRightRiseSlope(twoBelow)) {
                setFallingState(new DyingOfFalling2SlopeRiseRight());
                return fallingState.getState();
            }
            if (heightFallen + 1 > fatalHeight
                && BehaviourTools.isLeftRiseSlope(twoBelow)) {
                setFallingState(new DyingOfFalling2SlopeRiseLeft());
                return fallingState.getState();
            }
            if (t.isFlat(twoBelow)) // Flat block
            {
                setFallingState(new Falling1());
                return fallingState.getState();
            }
            if (t.isUpSlope(twoBelow)) {
                setFallingState(
                    new FallingOntoRiseRight(),
                    new FallingOntoRiseLeft(),
                    t.character
                );
                return fallingState.getState();
            } else {
                setFallingState(
                    new FallingOntoLowerRight(),
                    new FallingOntoLowerLeft(),
                    t.character
                );
                return fallingState.getState();
            }
        } else {
            setFallingState(new FallingNormal());
            return fallingState.getState();
        }
    }

    private boolean newStateWhenBlockBelow(BehaviourTools t, Block below) {
        if (below != null) {
            if (t.isUpSlope(below)) {
                setFallingState(
                    new Falling1OntoRiseRight(),
                    new Falling1OntoRiseLeft(),
                    t.character
                );
                return true;
            } else // Must be a slope in the opposite direction
            {
                setFallingState(
                    new Falling1OntoLowerRight(),
                    new Falling1OntoLowerLeft(),
                    t.character
                );
                return true;
            }
        }
        return false;
    }

    private State newStateWhenFatal(BehaviourTools t) {
        if (BehaviourTools.isRightRiseSlope(t.blockBelow())) {
            setFallingState(new DyingOfFallingSlopeRiseRight());
            return fallingState.getState();
        } else if (BehaviourTools.isLeftRiseSlope(t.blockBelow())) {
            setFallingState(new DyingOfFallingSlopeRiseLeft());
            return fallingState.getState();
        } else {
            setFallingState(new Falling1ToDeath());
            return fallingState.getState();
        }
    }

    private State newStateWhenNotTriggered() {
        if (heightFallen > fatalHeight) {
            if (heightFallen % 2 == 0) {
                setFallingState(new DyingOfFalling());
                return fallingState.getState();
            } else {
                setFallingState(new DyingOfFalling2());
                return fallingState.getState();
            }
        } else {
            setFallingState(new NotFalling());
            return fallingState.getState();
        }
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        boolean handled = moveRabbit(world, character, state);

        if (handled) {
            // Whenever we fall onto a slope, we are on top of it
            Block thisBlock = world.getBlockAt(character.x, character.y);
            if (thisBlock != null && thisBlock.shape != FLAT) {
                character.onSlope = true;
            } else {
                character.onSlope = false;
            }
        }

        return handled;
    }

    private boolean moveRabbit(World world, Character character, State state) {
        return fallingState.behave(world, character, this);
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfGtZero(
            saveState, "Falling.heightFallen", heightFallen
        );
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        heightFallen = BehaviourState.restoreFromState(
            saveState, "Falling.heightFallen", heightFallen
        );
    }
}
