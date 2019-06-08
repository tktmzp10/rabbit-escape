package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.things.environment.Fire;

public class Fire_C extends Fire {

    public Fire_C(int x, int y) {
        super(x, y, FIRE_C);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void changeStateRiseLeft() {
        state = FIRE_C_RISE_LEFT;
    }

    @Override
    public void changeStateRiseRight() {
        state = FIRE_C_RISE_RIGHT;
    }

    @Override
    public void changeStateFalling() {
        state = FIRE_C_FALLING;
    }

    @Override
    public void changeStateFallToRiseRight() {
        state = FIRE_C_FALL_TO_RISE_RIGHT;
    }

    @Override
    public void changeStateFallToRiseLeft() {
        state = FIRE_C_FALL_TO_RISE_LEFT;
    }
}
