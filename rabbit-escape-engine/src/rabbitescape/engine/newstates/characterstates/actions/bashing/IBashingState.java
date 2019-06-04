package rabbitescape.engine.newstates.characterstates.actions.bashing;

import rabbitescape.engine.ChangeDescription.*;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IBashingState
{
    public State newState();

    public boolean behave( World world, Character character );
}
