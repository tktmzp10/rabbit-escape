package rabbitescape.engine;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.textworld.TextWorldManip.createWorld;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rabbitescape.engine.textworld.TextWorldManip;
import rabbitescape.engine.things.characters.Rabbit;
import rabbitescape.engine.things.environment.Fire;
import rabbitescape.engine.things.environment.WaterRegion;
import rabbitescape.engine.things.environment.fire.*;
import rabbitescape.engine.util.Dimension;
import rabbitescape.engine.util.LookupTable2D;
import rabbitescape.engine.util.Position;
import rabbitescape.engine.util.WaterUtil;

public class TestFire {
	int x = 2;
	int y = 2;

	@Test(expected = RuntimeException.class)
	public void testCreateFire() throws Exception {
		Fire fire_A = FireFactory.createFire(1, 2, 0);
		Fire fire_B = FireFactory.createFire(1, 2, 1);
		Fire fire_C = FireFactory.createFire(1, 2, 2);
		Fire fire_D = FireFactory.createFire(1, 2, 3);

		assertTrue(fire_A instanceof Fire_A);
		assertTrue(fire_B instanceof Fire_B);
		assertTrue(fire_C instanceof Fire_C);
		assertTrue(fire_D instanceof Fire_D);
		
		Fire fire_RuntimeError = FireFactory.createFire(1, 2, 4);
	}

	@Test
	public void testCalcNewState() { // isStill is true -> calcNewStateOnFlatGround

        String[] worldString = {
                "# #",
                "# #",
                "###"
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(0, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState2() {//falling -> calcNewStateOnFlatGround

        String[] worldString = {
                "# #",
                "# #",
                "###"
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(1, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState3() {//isStill -> calcNewStateOnFlatGround->isRightRiseSlope True

        String[] worldString = {
                "# /",
                " /#",
                "/##"
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(2, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState4() {//isStill -> calcNewStateOnFlatGround->isLeftRiseSlope True

        String[] worldString = {
                "\\  ",
                " \\#",
                "/#\\"
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(0, 0, 0);
		fire.calcNewState(world);
	}

	
	@Test
	public void testCalcNewState5() {//Fire will be created in Water.-> isFireExtinguished  True

        String[] worldString = {
                "n  ",
                "   ",
                "   "
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(0, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState6() {//fire is Falling -> calcNewStateWhenFalling -> isRightRiseSlope True

        String[] worldString = {
                "   ",
                " / ",
                "   "
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(1, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState7() {//fire is Falling -> calcNewStateWhenFalling -> isLeftRiseSlope True

        String[] worldString = {
                "   ",
                " \\ ",
                "   "
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(1, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState8() {//isStill is true because someoneIsBridgingAt is true;

        String[] worldString = {
                "   ",
                "   ",
                "   "
            };
        World world = createWorld(worldString);
        Rabbit r = new Rabbit(1, 1, Direction.RIGHT);
        r.state = RABBIT_BRIDGING_LEFT_1;
        world.rabbits.add(r);
		Fire fire = FireFactory.createFire(0, 1, 0);
		fire.calcNewState(world);
	}

	
	
	@Test
	public void testStep() {

		World world = TextWorldManip.createEmptyWorld(x, y);
		Fire fire = FireFactory.createFire(x, y, 0);	
		fire.step(world);
	}
	
	@Test
	public void testSaveState() {

		boolean runtimeMeta = false;

		Fire fire = FireFactory.createFire(x, y, 0);	
		assertTrue(fire.saveState(runtimeMeta) instanceof HashMap);
	}
	
	@Test
	public void testOverlayText() {

		Fire fire = FireFactory.createFire(x, y, 0);	
		assertEquals(fire.overlayText(), "Fire");
	}


	

}
