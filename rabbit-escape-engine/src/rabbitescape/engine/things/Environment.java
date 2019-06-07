package rabbitescape.engine.things;

import rabbitescape.engine.ChangeDescription;
import rabbitescape.engine.Thing;

public abstract class Environment extends Thing {

    public Environment(int x, int y, ChangeDescription.State state) {
        super(x, y, state);
    }
}
