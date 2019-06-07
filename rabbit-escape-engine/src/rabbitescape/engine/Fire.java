package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;

public abstract class Fire extends Thing
{
    public int variant;

    private final State baseVariant;

    public Fire( int x, int y, State state )
    {
        super( x, y, state);
        baseVariant = state;
    }
    
    public static Fire createFire(int x, int y, int variant) {
    	switch ( variant )
        {
        case 0:
        	return new Fire_A(x, y);
        case 1:
            return new Fire_B(x, y);
        case 2:
            return new Fire_C(x, y);
        case 3:
            return new Fire_D(x, y);
        }
        throw new RuntimeException(
            "Variant outside expected range (0 - 3):" + variant );
    }


    @Override
    public void calcNewState( World world )
    {

        if (isFireExtinguished(world)) {
        	state = FIRE_EXTINGUISHING;
        	return;
        }
        
        Block blockBelow = world.getBlockAt( x, y + 1 );
        // Note: when flatBelow is true may be on a slope with a flat below,
        // or sitting on the flat
        boolean flatBelow = BehaviourTools.s_isFlat( blockBelow );

        if ( isStill(world, flatBelow) )
        {
            Block onBlock = world.getBlockAt( x, y );
            if ( BehaviourTools.isLeftRiseSlope( onBlock ) )
            {
                changeStateRiseLeft();
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( onBlock ) )
            {
                changeStateRiseRight();
                return;
            }
            // TODO: check here for fire falling on a bridger.
            // Fire going to a falling state may be OK
            // as bridger is burnt
            if ( flatBelow )
            {
                state = baseVariant;
                return;
            }
        }
        else // Falling
        {
            if ( BehaviourTools.isLeftRiseSlope( blockBelow ) )
            {
                changeStateFallToRiseLeft();
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( blockBelow ) )
            {
                changeStateFallToRiseRight();
                return;
            }
            changeStateFalling();
            return;
        }
    }
    
    private boolean isFireExtinguished(World world) {
        // Check if being extinguished.
        for ( WaterRegion waterRegion : world.waterTable.getItemsAt( x, y ) )
        {
            if ( waterRegion.getContents() > 0 )
            {
                
                return true;
            }
        }
		return false;
	}

    abstract void changeStateRiseLeft();


	abstract void changeStateRiseRight();


	abstract void changeStateFalling();


	abstract void changeStateFallToRiseRight();


	abstract void changeStateFallToRiseLeft();
	
	private boolean isStill(World world, boolean flatBelow) {
		return flatBelow
		|| ( world.getBlockAt( x, y ) != null )
		|| BridgeTools.someoneIsBridgingAt( world, x, y );
	}
   
    @Override
    public void step( World world )
    {
        switch ( state )
        {
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

            if ( y >= world.size.height )
            {
                world.changes.removeFire( this );
            }
            return;
        case FIRE_EXTINGUISHING:
            world.changes.removeFire( this );
            return;
        default:
            return;
        }

    }
    


    @Override
    public Map<String, String> saveState( boolean runtimeMeta )
    {
        return new HashMap<String, String>();
    }

    @Override
    public void restoreFromState( Map<String, String> state )
    {
    }

    @Override
    public String overlayText()
    {
        return "Fire";
    }
}
