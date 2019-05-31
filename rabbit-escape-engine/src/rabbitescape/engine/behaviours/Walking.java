package rabbitescape.engine.behaviours;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Direction.*;
import static rabbitescape.engine.Block.Shape.*;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.behaviours.walking.*;
import rabbitescape.engine.things.Character;

public class Walking extends Behaviour
{
    private IWalkingState walkingState, rightState, leftState;

    public void setWalkingState( IWalkingState walkingState )
    {
        this.walkingState = walkingState;
    }

    public void setRightState( IWalkingState rightState )
    {
        this.rightState = rightState;
    }

    public void setLeftState( IWalkingState leftState )
    {
        this.leftState = leftState;
    }

    public void setBothStates( IWalkingState rightState, IWalkingState leftState )
    {
        setRightState( rightState );
        setLeftState( leftState );
    }

    @Override
    public void cancel()
    {
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        return false; // To avoid cancelling other behaviours, return false
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        if ( t.isOnUpSlope() )
        {
            Block aboveNext = t.blockAboveNext();
            Block above = t.blockAbove();
            int nextX = t.nextX();
            int nextY = t.character.y - 1;

            if
            (
                t.isWall( aboveNext )
                    || Blocking.blockerAt( t.world, nextX, nextY )
                    || t.isRoof( above )
                    || ( t.isCresting() &&
                             Blocking.blockerAt( t.world, nextX, t.character.y ) )
            )
            {
                setBothStates( new TurningRightToLeftRising(), new TurningLeftToRightRising() );
            }
            else if ( t.isUpSlope( aboveNext ) )
            {
                setBothStates( new RisingRightContinue(), new RisingLeftContinue() );
            }
            else if ( t.isDownSlope( t.blockNext() ) )
            {
                setBothStates( new RisingAndLoweringRight(), new RisingAndLoweringLeft() );
            }
            else
            {
                setBothStates( new RisingRightEnd(), new RisingLeftEnd() );
            }
        }
        else if ( t.isOnDownSlope() )
        {
            int nextX = t.nextX();
            int nextY = t.character.y + 1;
            Block next = t.blockNext();
            Block belowNext = t.blockBelowNext();

            if (
                t.isWall( next )
                    || Blocking.blockerAt( t.world, nextX, nextY )
                    || ( t.isValleying() &&
                             Blocking.blockerAt( t.world, nextX, t.character.y ) )
            )
            {
                setBothStates( new TurningRightToLeftLowering(), new TurningLeftToRightLowering() );
            }
            else if ( t.isUpSlope( next ) )
            {
                setBothStates( new LoweringAndRisingRight(), new LoweringAndRisingLeft() );
            }
            else if ( t.isDownSlope( belowNext ) )
            {
                setBothStates( new LoweringRightContinue(), new LoweringLeftContinue() );
            }
            else
            {
                if ( Blocking.blockerAt( t.world, nextX, t.character.y ) )
                {
                    setBothStates( new TurningRightToLeftLowering(), new TurningLeftToRightLowering() );
                }
                else
                {
                    setBothStates( new LoweringRightEnd(), new LoweringLeftEnd() );
                }
            }
        }
        else  // On flat ground now
        {
            int nextX = t.nextX();
            int nextY = t.character.y;
            Block next = t.blockNext();

            if
            (
                t.isWall( next )
                    || Blocking.blockerAt( t.world, nextX, nextY )
            )
            {
                setBothStates( new TurningRightToLeft(), new TurningLeftToRight() );
            }
            else if ( t.isUpSlope( next ) )
            {
                setBothStates( new RisingRightStart(), new RisingLeftStart() );
            }
            else if ( t.isDownSlope( t.blockBelowNext() ) )
            {
                if ( Blocking.blockerAt( t.world, nextX, t.character.y + 1 ) )
                {
                    setBothStates( new TurningRightToLeft(), new TurningLeftToRight() );
                }
                else
                {
                    setBothStates( new LoweringRightStart(), new LoweringLeftStart() );
                }
            }
            else
            {
                setBothStates( new WalkingRight(), new WalkingLeft() );
            }
        }

        return t.rl( rightState.newState(), leftState.newState() );
    }

    @Override
    @SuppressWarnings("fallthrough")
    public boolean behave( World world, Character character, State state )
    {
        switch ( state )
        {
            case RABBIT_WALKING_LEFT:
            {
                --character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_WALKING_RIGHT:
            {
                ++character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_LOWERING_LEFT_END:
            {
                --character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_RISING_LEFT_START:
            case RABBIT_LOWERING_AND_RISING_LEFT:
            case RABBIT_RISING_AND_LOWERING_LEFT:
            {
                --character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_LOWERING_RIGHT_END:
            {
                ++character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_RISING_RIGHT_START:
            case RABBIT_LOWERING_AND_RISING_RIGHT:
            case RABBIT_RISING_AND_LOWERING_RIGHT:
            {
                ++character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_RISING_LEFT_END:
            {
                --character.y;
                --character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_RISING_LEFT_CONTINUE:
            {
                --character.y;
                --character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_RISING_RIGHT_END:
            {
                --character.y;
                ++character.x;
                character.onSlope = false;
                return true;
            }
            case RABBIT_RISING_RIGHT_CONTINUE:
            {
                --character.y;
                ++character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_LOWERING_LEFT_CONTINUE:
            case RABBIT_LOWERING_LEFT_START:
            {
                ++character.y;
                --character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_LOWERING_RIGHT_CONTINUE:
            case RABBIT_LOWERING_RIGHT_START:
            {
                ++character.y;
                ++character.x;
                character.onSlope = true;
                return true;
            }
            case RABBIT_TURNING_LEFT_TO_RIGHT:
                character.onSlope = false; // Intentional fall-through
            case RABBIT_TURNING_LEFT_TO_RIGHT_RISING:
            case RABBIT_TURNING_LEFT_TO_RIGHT_LOWERING:
            {
                character.dir = RIGHT;
                checkJumpOntoSlope( world, character );
                return true;
            }
            case RABBIT_TURNING_RIGHT_TO_LEFT:
                character.onSlope = false; // Intentional fall-through
            case RABBIT_TURNING_RIGHT_TO_LEFT_RISING:
            case RABBIT_TURNING_RIGHT_TO_LEFT_LOWERING:
            {
                character.dir = LEFT;
                checkJumpOntoSlope( world, character );
                return true;
            }
            default:
            {
                throw new AssertionError(
                    "Should have handled all states in Walking or before,"
                    + " but we are in walkingState " + state.name()
                );
            }
        }
    }

    /**
     * If we turn around near a slope, we jump onto it
     */
    private void checkJumpOntoSlope( World world, Character character )
    {
        Block thisBlock = world.getBlockAt( character.x, character.y );
        if ( isBridge( thisBlock ) )
        {
            Block aboveBlock = world.getBlockAt( character.x, character.y - 1 );
            if ( character.onSlope && isBridge( aboveBlock ) )
            {
                character.y--;
            }
            else
            {
                character.onSlope = true;
            }
        }
    }

    private boolean isBridge( Block block )
    {
        return (
               block != null
            && (
                   block.shape == BRIDGE_UP_LEFT
                || block.shape == BRIDGE_UP_RIGHT
            )
        );
    }

    @Override
    public String toString()
    {
        return "Walking";
    }
}
