package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;


public class Fire_D extends Fire {

	public Fire_D(int x, int y) {
		super(x, y, FIRE_D);
		// TODO Auto-generated constructor stub
	}
	
	protected void changeStateRiseLeft() {
		state = FIRE_D_RISE_LEFT;
	}
	
	protected void changeStateRiseRight() {
		state = FIRE_D_RISE_RIGHT;
	}
	
	protected void changeStateFalling() {
		state = FIRE_D_FALLING;
	}
	
	protected void changeStateFallToRiseRight() {
		state = FIRE_D_FALL_TO_RISE_RIGHT;
	}
	
	protected void changeStateFallToRiseLeft() {
		state = FIRE_D_FALL_TO_RISE_LEFT;
	}

}
