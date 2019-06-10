package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireA;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFallToRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFallToRiseRight;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireAFalling;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireARiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_a_states.FireARiseRight;
import rabbitescape.engine.things.environment.Fire;

public class Fire_A extends Fire {

    public Fire_A(int x, int y) {
        super(x, y, FIRE_A);
        setFireState(new FireA());
    }

    @Override
    public void changeStateRiseLeft() {
        setFireState( new FireARiseLeft() );
    }

    @Override
    public void changeStateRiseRight() {
        setFireState( new FireARiseRight() );
    }

    @Override
    public void changeStateFalling() {
        setFireState( new FireAFalling() );
    }

    @Override
    public void changeStateFallToRiseRight() {
        setFireState( new FireAFallToRiseRight() );
    }

    @Override
    public void changeStateFallToRiseLeft() {
        setFireState( new FireAFallToRiseLeft() );
    }
}
