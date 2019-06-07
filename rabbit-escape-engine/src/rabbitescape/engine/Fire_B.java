package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;


public class Fire_B extends Fire {

	public Fire_B(int x, int y) {
		super(x, y, FIRE_B);
		// TODO Auto-generated constructor stub
	}
	
	protected void changeStateRiseLeft() {
		state = FIRE_B_RISE_LEFT;
	}
	
	protected void changeStateRiseRight() {
		state = FIRE_B_RISE_RIGHT;
	}
	
	protected void changeStateFalling() {
		state = FIRE_B_FALLING;
	}
	
	protected void changeStateFallToRiseRight() {
		state = FIRE_B_FALL_TO_RISE_RIGHT;
	}
	
	protected void changeStateFallToRiseLeft() {
		state = FIRE_B_FALL_TO_RISE_LEFT;
	}
	

}
