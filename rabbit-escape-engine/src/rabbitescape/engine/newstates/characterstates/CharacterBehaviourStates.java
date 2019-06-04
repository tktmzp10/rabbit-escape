package rabbitescape.engine.newstates.characterstates;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.NewStates;
import rabbitescape.engine.World;
import rabbitescape.engine.newstates.CharacterStates;
import rabbitescape.engine.things.Character;

import java.util.Map;

public abstract class CharacterBehaviourStates extends CharacterStates
{
    public boolean behave(
        World world, Character character, State state
    ) {
        return behave( world, character, state, character.newState );
    }

    public abstract boolean behave(
        World world, Character character, State state, NewStates newState
    );

    public abstract State getState();

    public abstract State newState( BehaviourTools t, boolean triggered );

    public abstract boolean checkTriggered( Character character, World world );

    public abstract void cancel();

    public void saveState( Map<String, String> saveState )
    {
    }

    public void restoreFromState( Map<String, String> saveState )
    {
    }
}
