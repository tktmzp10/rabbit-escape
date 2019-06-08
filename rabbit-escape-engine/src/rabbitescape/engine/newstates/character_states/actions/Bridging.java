package rabbitescape.engine.newstates.character_states.actions;

import static rabbitescape.engine.Block.Material.EARTH;
import static rabbitescape.engine.Direction.RIGHT;
import static rabbitescape.engine.things.items.ItemType.*;
import static rabbitescape.engine.Block.Shape.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.character_states.CharacterActionStates;
import rabbitescape.engine.newstates.character_states.actions.bridging.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.bridging1.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.bridging2.*;
import rabbitescape.engine.newstates.character_states.actions.bridging.bridging3.*;
import rabbitescape.engine.things.Character;

public class Bridging extends CharacterActionStates {

    private static IBridgingState bridgingState;
    private int smallSteps = 0;
    private int bigSteps = 0;
    private BridgeType bridgeType = BridgeType.ALONG;

    public Bridging() {
        setBridgingState(new NotBridging());
    }

    public static void setBridgingState(IBridgingState state) {
        bridgingState = state;
    }

    public static void setBridgingState(
        IBridgingState right,
        IBridgingState left,
        Character character
    ) {
        if (character.dir == RIGHT) {
            setBridgingState(right);
        } else {
            setBridgingState(left);
        }
    }

    private static State bridgingState(
        BehaviourTools t,
        int bs,
        int ss,
        BridgeType bt
    ) {
        Block hereBlock = t.blockHere();
        Character character = t.character;
        World world = t.world;
        boolean slopeUp = isSlopeUp(character, hereBlock);
        int nx = nextX(character);
        int ny = nextY(character, slopeUp);

        Block nextBlock = world.getBlockAt(nx, ny);

        Block belowNextBlock = world.getBlockAt(nx, character.y);
        Block twoAboveHereBlock = world.getBlockAt(
            character.x,
            character.y - 2
        );
        Block aboveNextBlock = world.getBlockAt(nx, ny - 1);

        if ((nextBlock != null && nextBlock.riseDir() != character.dir) ||
            (Blocking.blockerAt(t.world, nx, ny)) // Something in the way
            || (
            belowNextBlock != null && belowNextBlock.riseDir() != character.dir
        ) // Clip land
            || (
            aboveNextBlock != null && BehaviourTools.isSolid(aboveNextBlock)
        ) // Bang head next
            || (bs < 3 && BehaviourTools.s_isFlat(twoAboveHereBlock))) {
            setBridgingState(new NotBridging());
            return bridgingState.getState(); // Stop bridging
        }

        boolean slopeDown = (
            (hereBlock != null) && (
                hereBlock.riseDir() == Direction.opposite(character.dir)
            )
        );

        if (ss == 3) {
            atThreeSmallSteps(character, slopeUp, slopeDown);
        } else if (ss == 2) {
            atTwoSmallSteps(bt, character);
        } else if (ss == 1) {
            atOneSmallStep(bt, character);
        } else {
            setBridgingState(new NotBridging());
        }

        return bridgingState.getState();
    }

    public void setBridgeType(BridgeType bridgeType) {
        this.bridgeType = bridgeType;
    }

    private static void atOneSmallStep(BridgeType bt, Character character) {
        switch (bt) {
            case ALONG: {
                setBridgingState(
                    new BridgingRight3(),
                    new BridgingLeft3(),
                    character
                );
                break;
            }
            case UP: {
                setBridgingState(
                    new BridgingUpRight3(),
                    new BridgingUpLeft3(),
                    character
                );
                break;
            }
            case DOWN_UP: {
                setBridgingState(
                    new BridgingDownUpRight3(),
                    new BridgingDownUpLeft3(),
                    character
                );
                break;
            }
            default: {
                throw new AssertionError("Unexpected bridge type: " + bt);
            }
        }
    }

    private static void atTwoSmallSteps(BridgeType bt, Character character) {
        switch (bt) {
            case ALONG: {
                setBridgingState(
                    new BridgingRight2(),
                    new BridgingLeft2(),
                    character
                );
                break;
            }
            case UP: {
                setBridgingState(
                    new BridgingUpRight2(),
                    new BridgingUpLeft2(),
                    character
                );
                break;
            }
            case DOWN_UP: {
                setBridgingState(
                    new BridgingDownUpRight2(),
                    new BridgingDownUpLeft2(),
                    character
                );
                break;
            }
            default: {
                throw new AssertionError("Unexpected bridge type: " + bt);
            }
        }
    }

    private static void atThreeSmallSteps(
        Character character,
        boolean slopeUp,
        boolean slopeDown
    ) {
        if (slopeUp) {
            setBridgingState(
                new BridgingUpRight1(),
                new BridgingUpLeft1(),
                character
            );
        } else if (slopeDown) {
            setBridgingState(
                new BridgingDownUpRight1(),
                new BridgingDownUpLeft1(),
                character
            );
        } else {
            setBridgingState(
                new BridgingRight1(),
                new BridgingLeft1(),
                character
            );
        }
    }

    private static State stateIntoWall(
        BehaviourTools t, Character character, World world, int ss
    ) {
        // We are facing a wall.  This makes us a bit keener to bridge.
        Block thisBlock = world.getBlockAt(character.x, character.y);

        boolean slopeUp = isSlopeUp(character, thisBlock);
        int bx = behindX(character);
        int ny = nextY(character, slopeUp);

        // Don't bridge if there is no block behind us (we're not in a hole)
        if (isSlope(thisBlock) && world.getBlockAt(bx, ny) == null) {
            setBridgingState(new NotBridging());
            return bridgingState.getState();
        }

        if (ss == 3) {
            atThreeSmallSteps(character, world, thisBlock);
        } else if (ss == 2) {
            atTwoSmallSteps(character, thisBlock);
        } else if (ss == 1) {
            atOneSmallStep(character, thisBlock);
        } else {
            setBridgingState(new NotBridging());
        }

        return bridgingState.getState();
    }

    private static void atOneSmallStep(Character character, Block thisBlock) {
        if (isSlope(thisBlock)) {
            setBridgingState(
                new BridgingInCornerUpRight3(),
                new BridgingInCornerUpLeft3(),
                character
            );
        } else {
            setBridgingState(
                new BridgingInCornerRight3(),
                new BridgingInCornerLeft3(),
                character
            );
        }
    }

    private static void atTwoSmallSteps(Character character, Block thisBlock) {
        if (isSlope(thisBlock)) {
            setBridgingState(
                new BridgingInCornerUpRight2(),
                new BridgingInCornerUpLeft2(),
                character
            );
        } else {
            setBridgingState(
                new BridgingInCornerRight2(),
                new BridgingInCornerLeft2(),
                character
            );
        }
    }

    private static void atThreeSmallSteps(
        Character character,
        World world,
        Block thisBlock
    ) {
        // Special behaviour where we bridge higher up because we are already
        // on top of a slope.
        if (isSlope(thisBlock)) {
            Block twoAbove = world.getBlockAt(character.x, character.y - 2);

            if (twoAbove == null || twoAbove.isBridge()) {
                setBridgingState(
                    new BridgingInCornerUpRight1(),
                    new BridgingInCornerUpLeft1(),
                    character
                );
            } else {
                // We would hit our head, so don't bridge.
                setBridgingState(new NotBridging());
            }
        } else {
            setBridgingState(
                new BridgingInCornerRight1(),
                new BridgingInCornerLeft1(),
                character
            );
        }
    }

    private static boolean startingIntoToWall(
        World world,
        Character character,
        int bs
    ) {
        Block hereBlock = world.getBlockAt(character.x, character.y);

        boolean slopeUp = isSlopeUp(character, hereBlock);
        int nx = nextX(character);
        int ny = nextY(character, slopeUp);

        Block nextBlock = world.getBlockAt(nx, ny);

        return (bs == 3)
            && (
            nextBlock != null && (
                nextBlock.riseDir() != character.dir || nextBlock.shape == FLAT
            )
        );
    }

    private static boolean isSlopeUp(Character character, Block hereBlock) {
        return (hereBlock != null)
            && (hereBlock.riseDir() == character.dir);
    }

    private static int nextY(Character character, boolean slopeUp) {
        int ret = character.y;
        ret += slopeUp ? -1 : 0;
        return ret;
    }

    private static int nextX(Character character) {
        int ret = character.x;
        ret += character.dir == RIGHT ? 1 : -1;
        return ret;
    }

    private static int behindX(Character character) {
        int ret = character.x;
        ret += character.dir == RIGHT ? -1 : 1;
        return ret;
    }

    private static boolean isSlope(Block thisBlock) {
        return (thisBlock != null && thisBlock.shape != FLAT);
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void cancel() {
        bigSteps = 0;
        smallSteps = 0;
    }

    @Override
    public boolean checkTriggered(Character character, World world) {
        nextStep();

        // Only pick up a token if we've finished, and we can bridge
        if (bigSteps <= 0) {
            BehaviourTools t = new BehaviourTools(character, world);
            State possibleState = bridgingState(t, 3, 3, bridgeType);

            // Only pick up if we can bridge
            if (possibleState != null) {
                return t.pickUpToken(bridge);
            }
        }
        return false;
    }

    @Override
    public State newState(BehaviourTools t, boolean triggered) {
        System.out.println("\tgetState()");
        if (triggered) {
            smallSteps = 3;
            bigSteps = 3;
        }

        if (startingIntoToWall(t.world, t.character, bigSteps)) {
            return stateIntoWall(t, t.character, t.world, smallSteps);
        }

        State ret = bridgingState(t, bigSteps, smallSteps, bridgeType);

        if (ret == null) {
            bigSteps = 0;
        }

        // Finished bridging
        if (bigSteps <= 0) {
            smallSteps = 0;
            setBridgingState(new NotBridging());
            ret = null;
        }

        return ret;
    }

    private void nextStep() {
        --smallSteps;
        if (smallSteps <= 0) {
            --bigSteps;
            smallSteps = 3;
        }
    }

    @Override
    public boolean behave(World world, Character character, State state) {
        switch (state) {
            case RABBIT_BRIDGING_RIGHT_1:
            case RABBIT_BRIDGING_RIGHT_2:
            case RABBIT_BRIDGING_LEFT_1:
            case RABBIT_BRIDGING_LEFT_2:
            case RABBIT_BRIDGING_IN_CORNER_RIGHT_1:
            case RABBIT_BRIDGING_IN_CORNER_LEFT_1:
            case RABBIT_BRIDGING_IN_CORNER_RIGHT_2:
            case RABBIT_BRIDGING_IN_CORNER_LEFT_2:
            case RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_1:
            case RABBIT_BRIDGING_IN_CORNER_UP_LEFT_1:
            case RABBIT_BRIDGING_IN_CORNER_UP_RIGHT_2:
            case RABBIT_BRIDGING_IN_CORNER_UP_LEFT_2: {
                bridgeType = BridgeType.ALONG;
            }
            case RABBIT_BRIDGING_UP_RIGHT_1:
            case RABBIT_BRIDGING_UP_RIGHT_2:
            case RABBIT_BRIDGING_UP_LEFT_1:
            case RABBIT_BRIDGING_UP_LEFT_2: {
                bridgeType = BridgeType.UP;
            }
            case RABBIT_BRIDGING_DOWN_UP_RIGHT_1:
            case RABBIT_BRIDGING_DOWN_UP_RIGHT_2:
            case RABBIT_BRIDGING_DOWN_UP_LEFT_1:
            case RABBIT_BRIDGING_DOWN_UP_LEFT_2: {
                bridgeType = BridgeType.DOWN_UP;
            }
        }
        return bridgingState.behave(world, character);
    }

    @Override
    public void saveState(Map<String, String> saveState) {
        BehaviourState.addToStateIfNotDefault(
            saveState,
            "Bridging.bridgeType",
            bridgeType.toString(),
            BridgeType.ALONG.toString()
        );

        BehaviourState.addToStateIfGtZero(
            saveState, "Bridging.bigSteps", bigSteps
        );

        BehaviourState.addToStateIfGtZero(
            saveState, "Bridging.smallSteps", smallSteps
        );
    }

    @Override
    public void restoreFromState(Map<String, String> saveState) {
        bridgeType = BridgeType.valueOf(
            BehaviourState.restoreFromState(
                saveState, "Bridging.bridgeType", bridgeType.toString()
            )
        );

        bigSteps = BehaviourState.restoreFromState(
            saveState, "Bridging.bigSteps", bigSteps
        );

        smallSteps = BehaviourState.restoreFromState(
            saveState, "Bridging.smallSteps", smallSteps
        );

        if (smallSteps > 0) {
            ++smallSteps;
        }
    }

    public enum BridgeType {
        ALONG,
        UP,
        DOWN_UP
    }
}
