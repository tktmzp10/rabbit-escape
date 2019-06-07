package rabbitescape.engine.things.items;

import rabbitescape.engine.err.RabbitEscapeException;

public class UnknownItemTypeException extends RabbitEscapeException {

    public final ItemType type;

    public UnknownItemTypeException(ItemType type) {
        this.type = type;
    }

    private static final long serialVersionUID = 1L;
}
