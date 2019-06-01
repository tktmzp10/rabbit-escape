package rabbitescape.engine.textworld;

import java.util.List;

import rabbitescape.engine.Entrance;
import rabbitescape.engine.Exit;
import rabbitescape.engine.Fire;
import rabbitescape.engine.Pipe;
import rabbitescape.engine.Thing;
import rabbitescape.engine.items.Item;
import rabbitescape.engine.items.ItemType;
import rabbitescape.engine.err.RabbitEscapeException;

public class ThingRenderer
{
    public static class UnknownTokenType extends RabbitEscapeException
    {
        public final ItemType type;

        public UnknownTokenType( ItemType type )
        {
            this.type = type;
        }

        private static final long serialVersionUID = 1L;
    }

    public static void render(
        Chars chars,
        List<Thing> things,
        boolean runtimeMeta
    )
    {
        for ( Thing thing : things )
        {
            chars.set(
                thing.x,
                thing.y,
                charForThing( thing ),
                thing.saveState( runtimeMeta )
            );
        }
    }

    private static char charForThing( Thing thing )
    {
        if ( thing instanceof Entrance )
        {
            return 'Q';
        }
        else if ( thing instanceof Exit )
        {
            return 'O';
        }
        else if ( thing instanceof Item )
        {
            return ( ( Item )thing ).getCharRepresentation();
        }
        else if ( thing instanceof Fire )
        {
            return 'A';
        }
        else if ( thing instanceof Pipe )
        {
            return 'P';
        }
        else
        {
            throw new AssertionError(
                "Unknown Thing type: " + thing.getClass() );
        }
    }
}
