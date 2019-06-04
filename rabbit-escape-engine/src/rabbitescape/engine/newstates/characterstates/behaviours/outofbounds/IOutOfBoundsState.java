package rabbitescape.engine.newstates.characterstates.behaviours.outofbounds;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.things.Character;
import rabbitescape.engine.World;

public interface IOutOfBoundsState
{
    public State newState();

    public boolean behave( World world, Character character );
}
