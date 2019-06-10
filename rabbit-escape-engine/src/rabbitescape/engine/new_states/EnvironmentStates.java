package rabbitescape.engine.new_states;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.NewStates;

public abstract class EnvironmentStates extends NewStates {

    @Override
    public abstract State getState();
}
