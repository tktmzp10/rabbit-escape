package rabbitescape.engine.textworld;

import java.util.List;

import rabbitescape.engine.things.environment.Entrance;
import rabbitescape.engine.things.environment.Exit;
import rabbitescape.engine.things.environment.Fire;
import rabbitescape.engine.things.environment.Pipe;
import rabbitescape.engine.Thing;
import rabbitescape.engine.things.Item;
import rabbitescape.engine.things.items.ItemType;
import rabbitescape.engine.err.RabbitEscapeException;

public class ThingRenderer {

    public static class UnknownItemType extends RabbitEscapeException {

        public final ItemType type;

        public UnknownItemType(ItemType type) {
            this.type = type;
        }

        private static final long serialVersionUID = 1L;
    }

    public static void render(
        Chars chars,
        List<Thing> things,
        boolean runtimeMeta
    ) {
        for (Thing thing : things) {
            chars.set(
                thing.x,
                thing.y,
                charForThing(thing),
                thing.saveState(runtimeMeta)
            );
        }
    }

    private static char charForThing(Thing thing) {
        if (thing instanceof Entrance) {
            return 'Q';
        } else if (thing instanceof Exit) {
            return 'O';
        } else if (thing instanceof Item) {
            return ((Item) thing).getCharRepresentation();
        } else if (thing instanceof Fire) {
            return 'A';
        } else if (thing instanceof Pipe) {
            return 'P';
        } else {
            throw new AssertionError(
                "Unknown Thing type: " + thing.getClass());
        }
    }
}
