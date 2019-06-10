package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.new_states.environment_states.fire_states.fire_b_states.FireBFallToRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_b_states.FireBFallToRiseRight;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_b_states.FireBFalling;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_b_states.FireBRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_b_states.FireBRiseRight;
import rabbitescape.engine.things.environment.Fire;


public class Fire_B extends Fire {

    public Fire_B(int x, int y) {
        super(x, y, FIRE_B);
    }

    @Override
    public void changeStateRiseLeft() {
        setEnvironmentState( new FireBRiseLeft() );
    }

    @Override
    public void changeStateRiseRight() {
        setEnvironmentState( new FireBRiseRight() );
    }

    @Override
    public void changeStateFalling() {
        setEnvironmentState( new FireBFalling() );
    }

    @Override
    public void changeStateFallToRiseRight() {
        setEnvironmentState( new FireBFallToRiseRight() );
    }

    @Override
    public void changeStateFallToRiseLeft() {
        setEnvironmentState( new FireBFallToRiseLeft() );
    }
}
