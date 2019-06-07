package rabbitescape.engine.newstates.characterstates.actions.crashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.things.Character;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_CRASHING;
import static rabbitescape.engine.ChangeDescription.State.RABBIT_WAITING_LEFT;

public class CrashingNormal implements ICrashingState {

    @Override
    public State newState() {
        return RABBIT_CRASHING;
    }

    @Override
    public boolean behave(
        World world, Character character
    ) {
        world.changes.killRabbit(character);
        return true;
    }
}
