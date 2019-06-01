package rabbitescape.engine.items;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;

public class BashItem extends Item
{
    private static final ItemType type = ItemType.bash;

    public BashItem( int x, int y )
    {
        super( x, y, State.TOKEN_BASH_ON_SLOPE, type );
    }

    public BashItem( int x, int y, World world )
    {
        super( x, y, State.TOKEN_BASH_ON_SLOPE, type, world );
    }

    @Override
    public char getCharRepresentation()
    {
        return 'b';
    }

    @Override
    public State getStillState()
    {
        return State.TOKEN_BASH_STILL;
    }

    @Override
    public State getFallingState()
    {
        return State.TOKEN_BASH_FALLING;
    }

    @Override
    public State getFallToSlopState()
    {
        return State.TOKEN_BASH_FALL_TO_SLOPE;
    }

    @Override
    public State getOnSlopeState()
    {
        return State.TOKEN_BASH_ON_SLOPE;
    }

    @Override
    public Item copyWithoutState()
    {
        return new BashItem( this.x, this.y );
    }
}
