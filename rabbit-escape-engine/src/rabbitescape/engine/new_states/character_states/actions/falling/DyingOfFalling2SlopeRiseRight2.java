package rabbitescape.engine.new_states.character_states.actions.falling;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.new_states.character_states.actions.Falling;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT_2;

public class DyingOfFalling2SlopeRiseRight2 implements IFallingState {

    @Override
    public State getState() {
        return RABBIT_DYING_OF_FALLING_2_SLOPE_RISE_RIGHT_2;
    }

    @Override
    public boolean behave(
        World world, Character character, Falling falling
    ) {
        world.changes.killRabbit(character);
        return true;
    }
}
