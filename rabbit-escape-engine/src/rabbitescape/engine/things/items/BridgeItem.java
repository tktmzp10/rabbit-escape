package rabbitescape.engine.things.items;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Item;

public class BridgeItem extends Item
{
    private static final ItemType type = ItemType.bridge;

    public BridgeItem( int x, int y )
    {
        super( x, y, State.TOKEN_BRIDGE_FALL_TO_SLOPE, type );
    }

    public BridgeItem( int x, int y, World world )
    {
        super( x, y, State.TOKEN_BRIDGE_FALL_TO_SLOPE, type, world );
    }

    @Override
    public char getCharRepresentation()
    {
        return 'i';
    }

    @Override
    public State getStillState()
    {
        return State.TOKEN_BRIDGE_STILL;
    }

    @Override
    public State getFallingState()
    {
        return State.TOKEN_BRIDGE_FALLING;
    }

    @Override
    public State getFallToSlopState()
    {
        return State.TOKEN_BRIDGE_FALL_TO_SLOPE;
    }

    @Override
    public State getOnSlopeState()
    {
        return State.TOKEN_BRIDGE_ON_SLOPE;
    }

    @Override
    public Item copyWithoutState()
    {
        return new BridgeItem( this.x, this.y );
    }
}
