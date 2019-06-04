package rabbitescape.engine.newstates.characterstates.actions.digging;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IDiggingState
{
    public State newState();

    public boolean behave( World world,  Character character );
}
