package rabbitescape.engine.things.environment.fire;

import static rabbitescape.engine.ChangeDescription.State.*;

import rabbitescape.engine.things.environment.Fire;


public class Fire_B extends Fire {

    public Fire_B(int x, int y) {
        super(x, y, FIRE_B);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void changeStateRiseLeft() {
        state = FIRE_B_RISE_LEFT;
    }

    @Override
    public void changeStateRiseRight() {
        state = FIRE_B_RISE_RIGHT;
    }

    @Override
    public void changeStateFalling() {
        state = FIRE_B_FALLING;
    }

    @Override
    public void changeStateFallToRiseRight() {
        state = FIRE_B_FALL_TO_RISE_RIGHT;
    }

    @Override
    public void changeStateFallToRiseLeft() {
        state = FIRE_B_FALL_TO_RISE_LEFT;
    }
}
