package rabbitescape.engine.newstates.characterstates.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Block.Shape.*;
import static rabbitescape.engine.Direction.RIGHT;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.characterstates.CharacterActionStates;
import rabbitescape.engine.newstates.characterstates.actions.Brollychuting;
import rabbitescape.engine.newstates.characterstates.actions.Climbing;
import rabbitescape.engine.newstates.characterstates.behaviours.falling.*;
import rabbitescape.engine.things.Character;

public class Falling extends CharacterActionStates {

    private IFallingState fallingState;
    private int heightFallen = 0;

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
        if (RABBIT_DYING_OF_FALLING_SLOPE_RISE_LEFT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFallingSlopeRiseLeft2());
            return fallingState.newState();
        }

        if (RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFalling2SlopeRiseLeft2());
            return fallingState.newState();
        }

        if (RABBIT_DYING_OF_FALLING_SLOPE_RISE_RIGHT
            == t.character.state) { // part 2 of animation always comes next
            setFallingState(new DyingOfFallingSlopeRiseRight2());
            return fallingState.newState();
        }

        if (RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT == t.character.state) {
            setFallingState(new DyingOfFalling2SlopeRiseRight2());
            return fallingState.newState();
        }

        if (!triggered) {
            if (heightFallen > fatalHeight) {
                if (heightFallen % 2 == 0) {
                    setFallingState(new DyingOfFalling());
                    return fallingState.newState();
                } else {
                    setFallingState(new DyingOfFalling2());
                    return fallingState.newState();
                }
            } else {
                setFallingState(new NotFalling());
                return fallingState.newState();
            }
        }

        if (
            // Going to die
            (heightFallen + 1 > fatalHeight)
                // during step
                && (t.isFlat(t.block2Below()) || t.blockBelow() != null)
        ) {
            if (BehaviourTools.isRightRiseSlope(t.blockBelow())) {
                setFallingState(new DyingOfFallingSlopeRiseRight());
                return fallingState.newState();
            } else if (BehaviourTools.isLeftRiseSlope(t.blockBelow())) {
                setFallingState(new DyingOfFallingSlopeRiseLeft());
                return fallingState.newState();
            } else {
                setFallingState(new Falling1ToDeath());
                return fallingState.newState();
            }
        } else {
            Block below = t.blockBelow();
            if (below != null) {
                if (t.isUpSlope(below)) {
                    setFallingState(
                        new Falling1OntoRiseRight(),
                        new Falling1OntoRiseLeft(),
                        t.character
                    );
                    return fallingState.newState();
                } else // Must be a slope in the opposite direction
                {
                    setFallingState(
                        new Falling1OntoLowerRight(),
                        new Falling1OntoLowerLeft(),
                        t.character
                    );
                    return fallingState.newState();
                }
            }

            Block twoBelow = t.block2Below();
            if (twoBelow != null) {
                if (heightFallen + 1 > fatalHeight
                    && BehaviourTools.isRightRiseSlope(twoBelow)) {
                    setFallingState(new DyingOfFalling2SlopeRiseRight());
                    return fallingState.newState();
                }
                if (heightFallen + 1 > fatalHeight
                    && BehaviourTools.isLeftRiseSlope(twoBelow)) {
                    setFallingState(new DyingOfFalling2SlopeRiseLeft());
                    return fallingState.newState();
                }
                if (t.isFlat(twoBelow)) // Flat block
                {
                    setFallingState(new Falling1());
                    return fallingState.newState();
                }
                if (t.isUpSlope(twoBelow)) {
                    setFallingState(
                        new FallingOntoRiseRight(),
                        new FallingOntoRiseLeft(),
                        t.character
                    );
                    return fallingState.newState();
                } else {
                    setFallingState(
                        new FallingOntoLowerRight(),
                        new FallingOntoLowerLeft(),
                        t.character
                    );
                    return fallingState.newState();
                }
            } else {
                setFallingState(new FallingNormal());
                return fallingState.newState();
            }
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
        switch (state) {
            case RABBIT_DYING_OF_FALLING:
            case RABBIT_DYING_OF_FALLING_2:
            case RABBIT_DYING_OF_FALLING_SLOPE_RISE_RIGHT_2:
            case RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT_2:
            case RABBIT_DYING_OF_FALLING_SLOPE_RISE_LEFT_2:
            case RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT_2: {
                world.changes.killRabbit(character);
                return true;
            }
            case RABBIT_FALLING:
            case RABBIT_FALLING_ONTO_LOWER_RIGHT:
            case RABBIT_FALLING_ONTO_LOWER_LEFT:
            case RABBIT_FALLING_ONTO_RISE_RIGHT:
            case RABBIT_FALLING_ONTO_RISE_LEFT:
            case RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT:
            case RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_LEFT: {
                heightFallen += 2;
                character.y = character.y + 2;
                return true;
            }
            case RABBIT_DYING_OF_FALLING_SLOPE_RISE_RIGHT:
            case RABBIT_DYING_OF_FALLING_SLOPE_RISE_LEFT:
            case RABBIT_FALLING_1_TO_DEATH:
            case RABBIT_FALLING_1:
            case RABBIT_FALLING_1_ONTO_LOWER_RIGHT:
            case RABBIT_FALLING_1_ONTO_LOWER_LEFT:
            case RABBIT_FALLING_1_ONTO_RISE_RIGHT:
            case RABBIT_FALLING_1_ONTO_RISE_LEFT: {
                heightFallen += 1;
                character.y = character.y + 1;
                return true;
            }
            default: {
                heightFallen = 0;
                return false;
            }
        }
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
