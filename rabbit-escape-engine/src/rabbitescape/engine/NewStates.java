package rabbitescape.engine;

import rabbitescape.engine.ChangeDescription.*;

public abstract class NewStates {

    public abstract State getState();

    public abstract State newState(BehaviourTools t, boolean triggered);

}
