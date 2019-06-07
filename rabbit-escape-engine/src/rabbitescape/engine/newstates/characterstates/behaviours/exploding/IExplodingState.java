package rabbitescape.engine.newstates.characterstates.behaviours.exploding;

import rabbitescape.engine.ChangeDescription;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

public interface IExplodingState {

    public ChangeDescription.State getState();

    public boolean behave(World world, Character character);
}
