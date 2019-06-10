package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states.FireCFallToRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states.FireCFallToRiseRight;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states.FireCFalling;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states.FireCRiseLeft;
import rabbitescape.engine.new_states.environment_states.fire_states.fire_c_states.FireCRiseRight;
import rabbitescape.engine.things.environment.Fire;

public class Fire_D extends Fire {

    public Fire_D(int x, int y) {
        super(x, y, FIRE_D);
    }

    @Override
    public void changeStateRiseLeft() {
        setFireState( new FireCRiseLeft() );
    }

    @Override
    public void changeStateRiseRight() {
        setFireState( new FireCRiseRight() );
    }

    @Override
    public void changeStateFalling() {
        setFireState( new FireCFalling() );
    }

    @Override
    public void changeStateFallToRiseRight() {
        setFireState( new FireCFallToRiseRight() );
    }

    @Override
    public void changeStateFallToRiseLeft() {
        setFireState( new FireCFallToRiseLeft() );
    }
}
