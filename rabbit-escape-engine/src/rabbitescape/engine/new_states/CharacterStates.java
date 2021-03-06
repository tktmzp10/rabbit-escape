package rabbitescape.engine.new_states;

import java.util.Map;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.NewStates;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public abstract class CharacterStates extends NewStates {

    public boolean triggered = false;

    public abstract State getState();

    /**
     * Subclasses examine the character's situation using BehaviourTools and return the state (see
     * ChangeDescription) for the next time step. This method may return null indicating that a
     * different CharacterStates must take over.
     *
     * Note that the state determines the animation used.
     */
    public abstract State newState(BehaviourTools t, boolean triggered);

    /**
     * Move the character in the world. Kill it, or record its safe exit.
     *
     * @return true if this behaviour has done all the work needed for this time step
     */
    public abstract boolean behave(World world, Character character, State state);

    public abstract boolean behave(World world, Character character, State state,
        NewStates newState);

    /**
     * Examine the character's situation and return true if this CharacterStates must take control.
     */
    public abstract boolean checkTriggered(Character character, World world);

    public abstract void cancel();

    public void saveState(Map<String, String> saveState) {
    }

    public void restoreFromState(Map<String, String> saveState) {
    }
}
