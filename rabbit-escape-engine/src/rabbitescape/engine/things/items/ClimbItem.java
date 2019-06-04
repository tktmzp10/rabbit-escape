package rabbitescape.engine.things.items;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Item;

public class ClimbItem extends Item
{
    private static final ItemType type = ItemType.climb;

    public ClimbItem( int x, int y )
    {
        super( x, y, State.TOKEN_CLIMB_FALL_TO_SLOPE, type );
    }

    public ClimbItem( int x, int y, World world )
    {
        super( x, y, State.TOKEN_CLIMB_FALL_TO_SLOPE, type, world );
    }

    @Override
    public char getCharRepresentation()
    {
        return 'c';
    }

    @Override
    public State getStillState()
    {
        return State.TOKEN_CLIMB_STILL;
    }

    @Override
    public State getFallingState()
    {
        return State.TOKEN_CLIMB_FALLING;
    }

    @Override
    public State getFallToSlopState()
    {
        return State.TOKEN_CLIMB_FALL_TO_SLOPE;
    }

    @Override
    public State getOnSlopeState()
    {
        return State.TOKEN_CLIMB_ON_SLOPE;
    }

    @Override
    public Item copyWithoutState()
    {
        return new ClimbItem( this.x, this.y );
    }
}
