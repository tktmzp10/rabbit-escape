package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;


public class Fire_A extends Fire {

	public Fire_A(int x, int y) {
		super(x, y, FIRE_A);
		// TODO Auto-generated constructor stub
	}
	
	protected void changeStateRiseLeft() {
		state = FIRE_A_RISE_LEFT;
	}
	
	protected void changeStateRiseRight() {
		state = FIRE_A_RISE_RIGHT;
	}
	
	protected void changeStateFalling() {
		state = FIRE_A_FALLING;
	}
	
	protected void changeStateFallToRiseRight() {
		state = FIRE_A_FALL_TO_RISE_RIGHT;
	}
	
	protected void changeStateFallToRiseLeft() {
		state = FIRE_A_FALL_TO_RISE_LEFT;
	}
}
