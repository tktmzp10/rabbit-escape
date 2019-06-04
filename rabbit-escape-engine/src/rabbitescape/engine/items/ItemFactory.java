package rabbitescape.engine.items;

import rabbitescape.engine.World;

public class ItemFactory
{
    private ItemFactory()
    {

    }

    public static Item createItem( int x, int y, ItemType type )
    throws UnknownItemTypeException
    {
        Item itemCreated;

        switch ( type )
        {
        case bash:
            itemCreated = new BashItem( x, y );
            break;
        case dig:
            itemCreated = new DigItem( x, y );
            break;
        case bridge:
            itemCreated = new BridgeItem( x, y );
            break;
        case block:
            itemCreated = new BlockItem( x, y );
            break;
        case climb:
            itemCreated = new ClimbItem( x, y );
            break;
        case explode:
            itemCreated = new ExplodeItem( x, y );
            break;
        case brolly:
            itemCreated = new BrollyItem( x, y );
            break;
        default:
            throw new UnknownItemTypeException( type );
        }

        return itemCreated;
    }

    public static Item createItem( int x, int y, ItemType type, World world )
    throws UnknownItemTypeException
    {
        Item itemCreated;

        switch ( type )
        {
        case bash:
            itemCreated = new BashItem( x, y, world );
            break;
        case dig:
            itemCreated = new DigItem( x, y, world );
            break;
        case bridge:
            itemCreated = new BridgeItem( x, y, world );
            break;
        case block:
            itemCreated = new BlockItem( x, y, world );
            break;
        case climb:
            itemCreated = new ClimbItem( x, y, world );
            break;
        case explode:
            itemCreated = new ExplodeItem( x, y, world );
            break;
        case brolly:
            itemCreated = new BrollyItem( x, y, world );
            break;
        default:
            throw new UnknownItemTypeException( type );
        }

        return itemCreated;
    }
}
