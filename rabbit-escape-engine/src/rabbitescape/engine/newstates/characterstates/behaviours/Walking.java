package rabbitescape.engine.newstates.characterstates.behaviours;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.characterstates.CharacterBehaviourStates;
import rabbitescape.engine.newstates.characterstates.actions.Blocking;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.*;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingondownslope.*;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonflat.*;
import rabbitescape.engine.newstates.characterstates.behaviours.walking.walkingonupslope.*;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.Block.Shape.BRIDGE_UP_LEFT;
import static rabbitescape.engine.Block.Shape.BRIDGE_UP_RIGHT;
import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Direction.LEFT;
import static rabbitescape.engine.Direction.RIGHT;

public class Walking extends CharacterBehaviourStates {

    private IWalkingState walkingState;

    public Walking() {
        setWalkingState(new WalkingRight());
    }

    public void setWalkingState(
        IWalkingState right,
        IWalkingState left,
        Character character
    ) {
        if (character.dir == RIGHT) {
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
            Block aboveNext = t.blockAboveNext();
            Block above = t.blockAbove();
            int nextX = t.nextX();
            int nextY = t.character.y - 1;

            if
            (
                t.isWall(aboveNext)
                    || Blocking.blockerAt(t.world, nextX, nextY)
                    || t.isRoof(above)
                    || (t.isCresting() &&
                    Blocking.blockerAt(t.world, nextX, t.character.y))
            ) {
                setWalkingState(
                    new TurningRightToLeftRising(),
                    new TurningLeftToRightRising(),
                    t.character
                );
            } else if (t.isUpSlope(aboveNext)) {
                setWalkingState(
                    new RisingRightContinue(),
                    new RisingLeftContinue(),
                    t.character
                );
            } else if (t.isDownSlope(t.blockNext())) {
                setWalkingState(
                    new RisingAndLoweringRight(),
                    new RisingAndLoweringLeft(),
                    t.character
                );
            } else {
                setWalkingState(
                    new RisingRightEnd(),
                    new RisingLeftEnd(),
                    t.character
                );
            }
        } else if (t.isOnDownSlope()) {
            int nextX = t.nextX();
            int nextY = t.character.y + 1;
            Block next = t.blockNext();
            Block belowNext = t.blockBelowNext();

            if (
                t.isWall(next)
                    || Blocking.blockerAt(t.world, nextX, nextY)
                    || (t.isValleying() &&
                    Blocking.blockerAt(t.world, nextX, t.character.y))
            ) {
                setWalkingState(
                    new TurningRightToLeftLowering(),
                    new TurningLeftToRightLowering(),
                    t.character
                );
            } else if (t.isUpSlope(next)) {
                setWalkingState(
                    new LoweringAndRisingRight(),
                    new LoweringAndRisingLeft(),
                    t.character
                );
            } else if (t.isDownSlope(belowNext)) {
                setWalkingState(
                    new LoweringRightContinue(),
                    new LoweringLeftContinue(),
                    t.character
                );
            } else {
                if (Blocking.blockerAt(t.world, nextX, t.character.y)) {
                    setWalkingState(
                        new TurningRightToLeftLowering(),
                        new TurningLeftToRightLowering(),
                        t.character
                    );
                } else {
                    setWalkingState(
                        new LoweringRightEnd(),
                        new LoweringLeftEnd(),
                        t.character
                    );
                }
            }
        } else  // On flat ground now
        {
            int nextX = t.nextX();
            int nextY = t.character.y;
            Block next = t.blockNext();

            if
            (
                t.isWall(next)
                    || Blocking.blockerAt(t.world, nextX, nextY)
            ) {
                setWalkingState(
                    new TurningRightToLeft(),
                    new TurningLeftToRight(),
                    t.character
                );
            } else if (t.isUpSlope(next)) {
                setWalkingState(
                    new RisingRightStart(),
                    new RisingLeftStart(),
                    t.character
                );
            } else if (t.isDownSlope(t.blockBelowNext())) {
                if (Blocking.blockerAt(t.world, nextX, t.character.y + 1)) {
                    setWalkingState(
                        new TurningRightToLeft(),
                        new TurningLeftToRight(),
                        t.character
                    );
                } else {
                    setWalkingState(
                        new LoweringRightStart(),
                        new LoweringLeftStart(),
                        t.character
                    );
                }
            } else {
                setWalkingState(
                    new WalkingRight(),
                    new WalkingLeft(),
                    t.character
                );
            }
        }

        return walkingState.getState();
    }

    @Override
    @SuppressWarnings("fallthrough")
    public boolean behave(World world, Character character, State state) {
        /*
        default:
        {
            throw new AssertionError(
                "Should have handled all states in Walking or before,"
                    + " but we are in state " + state.name()
            );
        }
         */

        //TODO: Deal with duplicate of checkJumpOntoSlope().
        return walkingState.behave(world, character);
    }

    @Override
    public boolean behave(
        World world, Character character, State state, NewStates newState
    ) {
        return behave(world, character, state);
    }
}
