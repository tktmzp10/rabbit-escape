package rabbitescape.engine.new_states.item_states.explode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.new_states.ItemState;

public class ExplodeItemStateTest {

    public static final State STILL = State.TOKEN_EXPLODE_STILL;
    public static final State FALLING = State.TOKEN_EXPLODE_FALLING;
    public static final State FALL_TO_SLOPE = State.TOKEN_EXPLODE_FALL_TO_SLOPE;
    public static final State ON_SLOPE = State.TOKEN_EXPLODE_ON_SLOPE;
    private ItemState itemState;

    @Before
    public void setUp() {
        itemState = new ExplodeStill();
    }

    @Test
    public void newState() {
        itemState.setMoving(true);
        itemState.setOnSlope(false);
        itemState.setSlopeBelow(false);
        itemState = itemState.newState();

        assertEquals(FALLING, itemState.getState());

        itemState.setMoving(true);
        itemState.setOnSlope(false);
        itemState.setSlopeBelow(true);
        itemState = itemState.newState();

        assertEquals(FALL_TO_SLOPE, itemState.getState());

        itemState.setMoving(false);
        itemState.setOnSlope(false);
        itemState.setSlopeBelow(false);
        itemState = itemState.newState();

        assertEquals(STILL, itemState.getState());

        itemState.setMoving(true);
        itemState.setOnSlope(true);
        itemState.setSlopeBelow(false);
        itemState = itemState.newState();

        assertEquals(ON_SLOPE, itemState.getState());
    }

    @Test
    public void isMoving() {
        assertFalse(itemState.isMoving());
        assertFalse(itemState.isOnSlope());
        assertFalse(itemState.isSlopeBelow());

        itemState.setMoving(true);
        assertTrue(itemState.isMoving());

        itemState.setOnSlope(true);
        assertTrue(itemState.isOnSlope());

        itemState.setSlopeBelow(true);
        assertTrue(itemState.isSlopeBelow());
    }

    @Test
    public void isFalling() {
        itemState = new ExplodeStill();
        assertFalse(itemState.isFalling());

        itemState = new ExplodeOnSlope();
        assertFalse(itemState.isFalling());

        itemState = new ExplodeFalling();
        assertTrue(itemState.isFalling());

        itemState = new ExplodeFallToSlope();
        assertTrue(itemState.isFalling());
    }
}
