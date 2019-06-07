package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;


public class Fire_C extends Fire {

	public Fire_C(int x, int y) {
		super(x, y, FIRE_C);
		// TODO Auto-generated constructor stub
	}
	
	protected void changeStateRiseLeft() {
		state = FIRE_C_RISE_LEFT;
	}
	
	protected void changeStateRiseRight() {
		state = FIRE_C_RISE_RIGHT;
	}
	
	protected void changeStateFalling() {
		state = FIRE_C_FALLING;
	}
	
	protected void changeStateFallToRiseRight() {
		state = FIRE_C_FALL_TO_RISE_RIGHT;
	}
	
	protected void changeStateFallToRiseLeft() {
		state = FIRE_C_FALL_TO_RISE_LEFT;
	}

}
