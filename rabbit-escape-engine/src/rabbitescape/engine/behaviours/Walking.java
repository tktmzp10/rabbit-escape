package rabbitescape.engine.behaviours;

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
        //TODO: if-elseif-else need to be simplified for readability.
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

        setWalkingState( t.character.dir == RIGHT ? rightState : leftState );

        return walkingState.newState();
    }

    @Override
    @SuppressWarnings("fallthrough")
    public boolean behave( World world, Character character, State state )
    {
        /*
        default:
        {
            throw new AssertionError(
                "Should have handled all states in Walking or before,"
                + " but we are in walkingState " + state.name()
            );
        }
        */

        //TODO: Must deal with duplicate code of checkJumpOntoSlope() and isBridge()
        return walkingState.behave( world, character );
    }

    @Override
    public String toString()
    {
        return "Walking";
    }
}
