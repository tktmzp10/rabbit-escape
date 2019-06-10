package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFallToRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFallToRiseRight;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFalling;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireARiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireARiseRight;
import rabbitescape.engine.things.environment.Fire;

public class Fire_A extends Fire {

    public Fire_A(int x, int y) {
        super(x, y, FIRE_A);
    }

    @Override
    public void changeStateRiseLeft() {
        setEnvironmentState( new FireARiseLeft() );
    }

    @Override
    public void changeStateRiseRight() {
        setEnvironmentState( new FireARiseRight() );
    }

    @Override
    public void changeStateFalling() {
        setEnvironmentState( new FireAFalling() );
    }

    @Override
    public void changeStateFallToRiseRight() {
        setEnvironmentState( new FireAFallToRiseRight() );
    }

    @Override
    public void changeStateFallToRiseLeft() {
        setEnvironmentState( new FireAFallToRiseLeft() );
    }
}
