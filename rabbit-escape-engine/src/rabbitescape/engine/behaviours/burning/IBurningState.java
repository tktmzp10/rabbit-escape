package rabbitescape.engine.behaviours.burning;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.Character;
import rabbitescape.engine.World;

public interface IBurningState
{
    public State newState();

    public boolean behave( World world, Character character );
}
