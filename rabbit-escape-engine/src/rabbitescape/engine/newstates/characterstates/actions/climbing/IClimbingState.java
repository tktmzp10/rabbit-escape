package rabbitescape.engine.newstates.characterstates.actions.climbing;

import rabbitescape.engine.BehaviourTools;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IClimbingState
{
    public State getState();

    public IClimbingState newState(
        BehaviourTools t,
        boolean abilityActive
    );

    public boolean behave( World world, Character character, boolean abilityActive );
}
