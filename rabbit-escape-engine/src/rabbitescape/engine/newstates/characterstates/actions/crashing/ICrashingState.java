package rabbitescape.engine.newstates.characterstates.actions.crashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface ICrashingState
{
    public State newState();

    public boolean behave( World world, Character character );
}