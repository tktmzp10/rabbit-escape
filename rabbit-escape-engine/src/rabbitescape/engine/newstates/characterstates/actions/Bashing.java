package rabbitescape.engine.newstates.characterstates.actions;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Direction.*;
import static rabbitescape.engine.things.items.ItemType.*;

import java.util.Map;

import rabbitescape.engine.*;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.newstates.characterstates.CharacterActionStates;
import rabbitescape.engine.newstates.characterstates.actions.bashing.*;
import rabbitescape.engine.things.Character;

public class Bashing extends CharacterActionStates
{
    private IBashingState bashingState;
    private int stepsOfBashing;

    public Bashing()
    {
        this.bashingState = new NotBashing();
    }

    @Override
    public State getState()
    {
        return null;
    }

    public void setBashingState( IBashingState bashingState )
    {
        this.bashingState = bashingState;
    }

    public void setBashingState(
        IBashingState right,
        IBashingState left,
        Character character
    )
    {
        if ( character.dir == RIGHT )
        {
            setBashingState( right );
        }
        else
        {
            setBashingState( left );
        }
    }

    @Override
    public void cancel()
    {
        stepsOfBashing = 0;
    }

    @Override
    public boolean checkTriggered( Character character, World world )
    {
        System.out.println( "/checkTriggered()" );
        BehaviourTools t = new BehaviourTools( character, world );

        return t.pickUpToken( bash );
    }

    @Override
    public State newState( BehaviourTools t, boolean triggered )
    {
        System.out.println( "/newState()" );
        if ( triggered || stepsOfBashing > 0 )
        {
            System.out.println( "//triggered || stepsOfBashing > 0" );
            if (
                t.isOnUpSlope()
                    && t.blockAboveNext() != null
            )
            {
                System.out.println( "///t.isOnUpSlope() && t.blockAboveNext() != null" );
                if (t.blockAboveNext().material == Block.Material.METAL)
                {
                    stepsOfBashing = 0;
                    setBashingState(
                        new BashingUselesslyRightUp(),
                        new BashingUselesslyLeftUp(),
                        t.character
                    );
                }
                else
                {
                    stepsOfBashing = 2;
                    setBashingState(
                        new BashingUpRight(),
                        new BashingUpLeft(),
                        t.character
                    );
                }
            }
            else if (
                t.isOnUpSlope()
                    && t.blockAboveNext() == null
                    && triggered
            )
            {
                System.out.println( "///t.isOnUpSlope() && t.blockAboveNext() == null && triggered" );
                setBashingState(
                    new BashingUselesslyRightUp(),
                    new BashingUselesslyLeftUp(),
                    t.character
                );
            }
            else if ( t.blockNext() != null )
            {
                System.out.println( "///t.blockNext() != null" );
                if ( t.blockNext().material == Block.Material.METAL )
                {
                    stepsOfBashing = 0;
                    setBashingState(
                        new BashingUselesslyRight(),
                        new BashingUselesslyLeft(),
                        t.character
                    );
                }
                else
                {
                    stepsOfBashing = 2;
                    setBashingState(
                        new BashingRight(),
                        new BashingLeft(),
                        t.character
                    );
                }
            }
            else if ( triggered )
            {
                System.out.println( "///triggered" );
                setBashingState(
                    new BashingUselesslyRight(),
                    new BashingUselesslyLeft(),
                    t.character
                );
            }
            else
            {
                System.out.println( "///stepsOfBashing" );
                --stepsOfBashing;
            }
        }
        else
        {
            System.out.println( "/stepsOfBashing" );
            --stepsOfBashing;
        }

        return bashingState.newState();
    }

    @Override
    public boolean behave( World world, Character character, State state )
    {
        System.out.println( "/behave()" );
        switch ( state )
        {
            case RABBIT_BASHING_RIGHT:
            case RABBIT_BASHING_LEFT:
            {
                System.out.println( "//RABBIT_BASHING_RIGHT, RABBIT_BASHING_LEFT" );
                character.slopeBashHop = false;
                world.changes.removeBlockAt( destX( character ), character.y );
                return true;
            }
            case RABBIT_BASHING_UP_RIGHT:
            case RABBIT_BASHING_UP_LEFT:
            {
                System.out.println( "//RABBIT_BASHING_UP_RIGHT, RABBIT_BASHING_UP_LEFT" );
                world.changes.removeBlockAt( destX( character ), character.y - 1 );
                character.slopeBashHop = true;
                character.y -= 1;
                return true;
            }
            case RABBIT_BASHING_USELESSLY_RIGHT:
            case RABBIT_BASHING_USELESSLY_LEFT:
            {
                System.out.println( "//RABBIT_BASHING_USELESSLY_RIGHT, RABBIT_BASHING_USELESSLY_LEFT" );
                character.slopeBashHop = false;
                return true;
            }
            case RABBIT_BASHING_USELESSLY_RIGHT_UP:
            case RABBIT_BASHING_USELESSLY_LEFT_UP:
            {
                System.out.println( "//RABBIT_BASHING_USELESSLY_RIGHT_UP, RABBIT_BASHING_USELESSLY_LEFT_UP" );
                character.slopeBashHop = true;
                character.y -= 1;
                return true;
            }
            default:
            {
                System.out.println( "//default" );
                character.slopeBashHop = false;
                return false;
            }
        }
    }

    private int destX( Character character )
    {
        return ( character.dir == RIGHT ) ? character.x + 1 : character.x - 1;
    }

    @Override
    public void saveState( Map<String, String> saveState )
    {
        BehaviourState.addToStateIfGtZero(
            saveState, "Bashing.stepsOfBashing", stepsOfBashing
        );
    }

    @Override
    public void restoreFromState( Map<String, String> saveState )
    {
        stepsOfBashing = BehaviourState.restoreFromState(
            saveState, "Bashing.stepsOfBashing", stepsOfBashing
        );

        if ( stepsOfBashing > 0 )
        {
            ++stepsOfBashing;
        }
    }
}
