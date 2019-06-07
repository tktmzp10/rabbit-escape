package rabbitescape.engine;

import java.util.Locale;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;

public abstract class Thing implements ShownOnOverlay {

    public int x;
    public int y;
    public State state;
    public NewStates newState;

    public Thing(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public Thing(int x, int y, NewStates newState) {
        this.x = x;
        this.y = y;
        this.newState = newState;
        setState(newState);
    }

    public Thing(
        int x,
        int y,
        State state,
        NewStates newState
    ) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.newState = newState;
    }

    public void setState(NewStates newState) {
        this.state = newState.getState();
    }

    public void setNewState(NewStates newState) {
        this.newState = newState;
        setState(newState);
    }

    public abstract void calcNewState(World world);

    public abstract void step(World world);

    public abstract Map<String, String> saveState(boolean runtimeMeta);

    public abstract void restoreFromState(Map<String, String> state);

    public abstract String overlayText();

    public String stateName() {
        return state.name().toLowerCase(Locale.ENGLISH);
    }
}
