package rabbitescape.engine;

import rabbitescape.engine.ChangeDescription.State;

public class NewChangeState
{
    public int x;
    public int y;
    public State state;
    public NewStates newState;

    public NewChangeState( int x, int y, State state )
    {
        this.x = x;
        this.y = y;
        this.state = state;
    }
}
