package rabbitescape.engine.newstates.characterstates.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Direction.RIGHT;
import static rabbitescape.engine.things.items.ItemType.*;
import static rabbitescape.engine.Block.Material.*;
import static rabbitescape.engine.Block.Shape.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.newstates.characterstates.CharacterActionStates;
import rabbitescape.engine.newstates.characterstates.actions.bridging.*;
import rabbitescape.engine.things.Character;

public class Bridging extends CharacterActionStates
{
    private static IBridgingState bridgingState;

    public Bridging()
    {
        setBridgingState( new NotBridging() );
    }

    public static void setBridgingState( IBridgingState state )
    {
        bridgingState = state;
    }

    public static void setBridgingState(
        IBridgingState right,
        IBridgingState left,
        Character character
    )
    {
        if ( character.dir == RIGHT )
        {
            setBridgingState( right );
        }
        else
        {
            setBridgingState( left );
        }
    }

    @Override
    public State getState()
    {
        return null;
    }

    public enum BridgeType
    {
        ALONG,
        UP,
        DOWN_UP
    }

    private int smallSteps = 0;
    private int bigSteps = 0;
    private BridgeType bridgeType = BridgeType.ALONG;

    @Override
    public void cancel()
    {
        bigSteps = 0;
        smallSteps = 0;
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        nextStep();

        if ( bigSteps <= 0 )
            // Only pick up a token if we've finished, and we can bridge
        {
            BehaviourTools t = new BehaviourTools( character, world );

            State possibleState = bridgingState( t, 3, 3, bridgeType );

            if ( possibleState != null ) // Only pick up if we can bridge
            {
                return t.pickUpToken( bridge );
            }
        }
        return false;
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( triggered )
        {
            smallSteps = 3;
            bigSteps = 3;
        }

        State ret = bridgingState( t, bigSteps, smallSteps, bridgeType );

        if ( ret == null )
        {
            bigSteps = 0;
        }

        if ( bigSteps <= 0 )
        {
            smallSteps = 0;
            return null;   // Finished bridging
        }

        return ret;
    }

    private static State bridgingState(
        BehaviourTools t,
        int bs,
        int ss,
        BridgeType bt
    )
    {
        Block hereBlock = t.blockHere();

        Character character = t.character;
        World world = t.world;

        if ( startingIntoToWall( world, character, bs ) )
        {
            return stateIntoWall( t, character, world, ss );
        }

        boolean slopeUp = isSlopeUp( character, hereBlock );
        int nx = nextX( character );
        int ny = nextY( character, slopeUp );

        Block nextBlock = world.getBlockAt( nx, ny );

        Block belowNextBlock = world.getBlockAt( nx, character.y );
        Block twoAboveHereBlock = world.getBlockAt( character.x, character.y - 2 );
        Block aboveNextBlock = world.getBlockAt( nx, ny - 1 );

        if (
            (
                   // Something in the way
                   nextBlock != null
                && nextBlock.riseDir() != character.dir
            ) || (
                Blocking.blockerAt( t.world, nx, ny )
            ) || (
                   // Clip land
                   belowNextBlock != null
                && belowNextBlock.riseDir() != character.dir
            ) || (
                    // Bang head next
                    aboveNextBlock != null
                 && BehaviourTools.isSolid( aboveNextBlock )
            ) || (
                    // Bang head here, mid-build
                    bs < 3
                 && BehaviourTools.s_isFlat( twoAboveHereBlock )
            )
        )
        {
            setBridgingState( new NotBridging() );
            return bridgingState.newState(); // Stop bridging
        }

        boolean slopeDown = (
               ( hereBlock != null )
            && ( hereBlock.riseDir() == Direction.opposite( character.dir ) )
        );

        switch( ss )
        {
            case 3:
            {
                if ( slopeUp )
                {
                    setBridgingState(
                        new BridgingUpRight1(),
                        new BridgingUpLeft1(),
                        character
                    );
                    break;
                }
                else if ( slopeDown )
                {
                    setBridgingState(
                        new BridgingDownUpRight1(),
                        new BridgingDownUpLeft1(),
                        character
                    );
                    break;
                }
                else
                {
                    setBridgingState(
                        new BridgingRight1(),
                        new BridgingLeft1(),
                        character
                    );
                    break;
                }
            }
            case 2:
            {
                switch( bt )
                {
                    case ALONG:
                    {
                        setBridgingState(
                            new BridgingRight2(),
                            new BridgingLeft2(),
                            character
                        );
                        break;
                    }
                    case UP:
                    {
                        setBridgingState(
                            new BridgingUpRight2(),
                            new BridgingUpLeft2(),
                            character
                        );
                        break;
                    }
                    case DOWN_UP:
                    {
                        setBridgingState(
                            new BridgingDownUpRight2(),
                            new BridgingDownUpLeft2(),
                            character
                        );
                        break;
                    }
                    default:
                    {
                        throw new AssertionError(
                            "Unexpected bridge type: " + bt );
                    }
                }
            }
            case 1:
            {
                switch( bt )
                {
                    case ALONG:
                    {
                        setBridgingState(
                            new BridgingRight3(),
                            new BridgingLeft3(),
                            character
                        );
                        break;
                    }
                    case UP:
                    {
                        setBridgingState(
                            new BridgingUpRight3(),
                            new BridgingUpLeft3(),
                            character
                        );
                        break;
                    }
                    case DOWN_UP:
                    {
                        setBridgingState(
                            new BridgingDownUpRight3(),
                            new BridgingDownUpLeft3(),
                            character
                        );
                        break;
                    }
                    default:
                    {
                        throw new AssertionError(
                            "Unexpected bridge type: " + bt );
                    }
                }
            }
            default:
            {
                setBridgingState( new NotBridging() );
            }
        }

        return bridgingState.newState();
    }

    private static State stateIntoWall(
        BehaviourTools t, Character character, World world, int ss )
    {
        // We are facing a wall.  This makes us a bit keener to
        // bridge.
        Block thisBlock = world.getBlockAt( character.x, character.y );

        boolean slopeUp = isSlopeUp( character, thisBlock );
        int bx = behindX( character );
        int ny = nextY( character, slopeUp );

        // Don't bridge if there is no block behind us (we're not in a hole)
        if ( isSlope( thisBlock ) && world.getBlockAt( bx, ny ) == null )
        {
            setBridgingState( new NotBridging() );
            return bridgingState.newState();
        }

        switch( ss )
        {
            case 3:
            {
                if ( isSlope( thisBlock ) )
                {
                    // Special behaviour where we bridge higher up because we
                    // are already on top of a slope.

                    Block twoAbove = world.getBlockAt( character.x, character.y - 2 );

                    if ( twoAbove == null || twoAbove.isBridge() ) {
                        setBridgingState(
                            new BridgingInCornerUpRight1(),
                            new BridgingInCornerUpLeft1(),
                            character
                        );
                        break;
                    }
                    else
                    {
                        // We would hit our head, so don't bridge.
                        setBridgingState( new NotBridging() );
                        break;
                    }
                }
                else
                {
                    setBridgingState(
                        new BridgingInCornerRight1(),
                        new BridgingInCornerLeft1(),
                        character
                    );
                    break;
                }
            }
            case 2:
            {
                if ( isSlope( thisBlock ) )
                {
                    setBridgingState(
                        new BridgingInCornerUpRight2(),
                        new BridgingInCornerUpLeft2(),
                        character
                    );
                    break;
                }
                else
                {
                    setBridgingState(
                        new BridgingInCornerRight2(),
                        new BridgingInCornerLeft2(),
                        character
                    );
                    break;
                }
            }
            case 1:
            {
                if ( isSlope( thisBlock ) )
                {
                    setBridgingState(
                        new BridgingInCornerUpRight3(),
                        new BridgingInCornerUpLeft3(),
                        character
                    );
                    break;
                }
                else
                {
                    setBridgingState(
                        new BridgingInCornerRight3(),
                        new BridgingInCornerLeft3(),
                        character
                    );
                    break;
                }
            }
            default:
            {
                setBridgingState( new NotBridging() );
            }
        }

        return bridgingState.newState();
    }

    private static boolean startingIntoToWall(
        World world,
        Character character,
        int bs
    )
    {
        Block hereBlock = world.getBlockAt( character.x, character.y );

        boolean slopeUp = isSlopeUp( character, hereBlock );
        int nx = nextX( character );
        int ny = nextY( character, slopeUp );

        Block nextBlock = world.getBlockAt( nx, ny );

        return (
           bs == 3
        )
        &&
        (
               nextBlock != null
            &&
            (
                   nextBlock.riseDir() != character.dir
                || nextBlock.shape == FLAT
            )
         );
    }

    private static boolean isSlopeUp( Character character, Block hereBlock )
    {
        return ( hereBlock != null )
          && ( hereBlock.riseDir() == character.dir );
    }

    private static int nextY( Character character, boolean slopeUp )
    {
        int ret = character.y;
        ret += slopeUp ? -1 : 0;
        return ret;
    }

    private static int nextX( Character character )
    {
        int ret = character.x;
        ret += character.dir == RIGHT ? 1 : -1;
        return ret;
    }

    private static int behindX( Character character )
    {
        int ret = character.x;
        ret += character.dir == RIGHT ? -1 : 1;
        return ret;
    }

    private void nextStep()
    {
        --smallSteps;
        if ( smallSteps <= 0 )
        {
            --bigSteps;
            smallSteps = 3;
        }
    }

    private static boolean isSlope( Block thisBlock )
    {
        return ( thisBlock != null && thisBlock.shape != FLAT );
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        return bridgingState.behave( world, character, bridgeType );
    }

    @Override
    public void saveState( Map<String, String> saveState )
    {
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
    public void restoreFromState( Map<String, String> saveState )
    {
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

        if ( smallSteps > 0 )
        {
            ++smallSteps;
        }
    }
}
