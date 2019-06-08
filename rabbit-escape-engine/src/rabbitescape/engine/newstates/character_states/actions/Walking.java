package rabbitescape.engine.newstates.character_states.actions;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterBehaviourStates;
import rabbitescape.engine.newstates.character_states.actions.walking.*;
import rabbitescape.engine.newstates.character_states.actions.walking.walkingondownslope.*;
import rabbitescape.engine.newstates.character_states.actions.walking.walkingonflat.*;
import rabbitescape.engine.newstates.character_states.actions.walking.walkingonupslope.*;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Shape.*;
import static rabbitescape.engine.Direction.*;

public class Walking extends CharacterBehaviourStates {

    private IWalkingState walkingState;

    public Walking() {
        setWalkingState(new WalkingRight());
    }

    public void setWalkingState(IWalkingState right, IWalkingState left, Direction direction) {
        if (direction == RIGHT) {
            setWalkingState(right);
        } else {
            setWalkingState(left);
        }
    }

    public void setWalkingState(IWalkingState walkingState) {
        this.walkingState = walkingState;
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void cancel() {
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        return false; // To avoid cancelling other actions, return false
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        if (t.isOnUpSlope()) {
            newStateOnUpSlope(t);
        } else if (t.isOnDownSlope()) {
            newStateOnDownSlope(t);
        } else {
            newStateOnFlatGround(t);
        }

        return walkingState.getState();
    }

    private void newStateOnFlatGround(BehaviourTools t) {
        int nextX = t.nextX();
        int nextY = t.character.y;
        Block next = t.blockNext();

        if (t.isWall(next) || Blocking.blockerAt(t.world, nextX, nextY)) {
            setWalkingState(new TurningRightToLeft(),
                new TurningLeftToRight(),
                t.character.dir);
        } else if (t.isUpSlope(next)) {
            setWalkingState(new RisingRightStart(),
                new RisingLeftStart(),
                t.character.dir);
        } else if (t.isDownSlope(t.blockBelowNext())) {
            if (Blocking.blockerAt(t.world, nextX, t.character.y + 1)) {
                setWalkingState(new TurningRightToLeft(),
                    new TurningLeftToRight(),
                    t.character.dir);
            } else {
                setWalkingState(new LoweringRightStart(),
                    new LoweringLeftStart(),
                    t.character.dir);
            }
        } else {
            setWalkingState(new WalkingRight(),
                new WalkingLeft(),
                t.character.dir);
        }
    }

    private void newStateOnDownSlope(BehaviourTools t) {
        int nextX = t.nextX();
        int nextY = t.character.y + 1;
        Block next = t.blockNext();
        Block belowNext = t.blockBelowNext();

        if (t.isWall(next)
            || Blocking.blockerAt(t.world, nextX, nextY)
            || (t.isValleying() && Blocking.blockerAt(t.world, nextX, t.character.y))) {
            setWalkingState(new TurningRightToLeftLowering(),
                new TurningLeftToRightLowering(),
                t.character.dir);
        } else if (t.isUpSlope(next)) {
            setWalkingState(new LoweringAndRisingRight(),
                new LoweringAndRisingLeft(),
                t.character.dir);
        } else if (t.isDownSlope(belowNext)) {
            setWalkingState(new LoweringRightContinue(),
                new LoweringLeftContinue(),
                t.character.dir);
        } else {
            if (Blocking.blockerAt(t.world, nextX, t.character.y)) {
                setWalkingState(new TurningRightToLeftLowering(),
                    new TurningLeftToRightLowering(),
                    t.character.dir);
            } else {
                setWalkingState(new LoweringRightEnd(),
                    new LoweringLeftEnd(),
                    t.character.dir);
            }
        }
    }

    private void newStateOnUpSlope(BehaviourTools t) {
        Block aboveNext = t.blockAboveNext();
        Block above = t.blockAbove();
        int nextX = t.nextX();
        int nextY = t.character.y - 1;

        if (t.isWall(aboveNext)
            || Blocking.blockerAt(t.world, nextX, nextY)
            || t.isRoof(above)
            || (t.isCresting() && Blocking.blockerAt(t.world, nextX, t.character.y))) {
            setWalkingState(new TurningRightToLeftRising(),
                new TurningLeftToRightRising(),
                t.character.dir);
        } else if (t.isUpSlope(aboveNext)) {
            setWalkingState(new RisingRightContinue(),
                new RisingLeftContinue(),
                t.character.dir);
        } else if (t.isDownSlope(t.blockNext())) {
            setWalkingState(new RisingAndLoweringRight(),
                new RisingAndLoweringLeft(),
                t.character.dir);
        } else {
            setWalkingState(new RisingRightEnd(),
                new RisingLeftEnd(),
                t.character.dir);
        }
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        return walkingState.behave(world, character);
    }

    /**
     * If we turn around near a slope, we jump onto it
     */
    public static void checkJumpOntoSlope(World world, Character character) {
        Block thisBlock = world.getBlockAt(character.x, character.y);
        if (isBridge(thisBlock)) {
            Block aboveBlock = world.getBlockAt(character.x, character.y - 1);
            if (character.onSlope && isBridge(aboveBlock)) {
                character.y--;
            } else {
                character.onSlope = true;
            }
        }
    }

    private static boolean isBridge(Block block) {
        return (block != null && (block.shape == BRIDGE_UP_LEFT || block.shape == BRIDGE_UP_RIGHT));
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState) {
        return behave(world, character, state);
    }
}
