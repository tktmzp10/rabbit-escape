package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.things.environment.Fire;

public class Fire_A extends Fire {

    public Fire_A(int x, int y) {
        super(x, y, FIRE_A);
    }

    @Override
    public void changeStateRiseLeft() {
        state = FIRE_A_RISE_LEFT;
    }

    @Override
    public void changeStateRiseRight() {
        state = FIRE_A_RISE_RIGHT;
    }

    @Override
    public void changeStateFalling() {
        state = FIRE_A_FALLING;
    }

    @Override
    public void changeStateFallToRiseRight() {
        state = FIRE_A_FALL_TO_RISE_RIGHT;
    }

    @Override
    public void changeStateFallToRiseLeft() {
        state = FIRE_A_FALL_TO_RISE_LEFT;
    }
}
