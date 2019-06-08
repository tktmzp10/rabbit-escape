package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.things.environment.Fire;

public class Fire_D extends Fire {

    public Fire_D(int x, int y) {
        super(x, y, FIRE_D);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void changeStateRiseLeft() {
        state = FIRE_D_RISE_LEFT;
    }

    @Override
    public void changeStateRiseRight() {
        state = FIRE_D_RISE_RIGHT;
    }

    @Override
    public void changeStateFalling() {
        state = FIRE_D_FALLING;
    }

    @Override
    public void changeStateFallToRiseRight() {
        state = FIRE_D_FALL_TO_RISE_RIGHT;
    }

    @Override
    public void changeStateFallToRiseLeft() {
        state = FIRE_D_FALL_TO_RISE_LEFT;
    }
}
