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
import rabbitescape.engine.things.environment.fire.FireFactory;
import rabbitescape.engine.util.Dimension;
import rabbitescape.engine.util.LookupTable2D;
import rabbitescape.engine.util.Position;
import rabbitescape.engine.util.WaterUtil;

public class TestFire {


	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public void testCreateFire() throws Exception {
		Fire fire_A = FireFactory.createFire(1, 2, 0);
		Fire fire_B = FireFactory.createFire(1, 2, 1);
		Fire fire_C = FireFactory.createFire(1, 2, 2);
		Fire fire_D = FireFactory.createFire(1, 2, 3);
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
	public void testCalcNewState5() {

        String[] worldString = {
                "#  ",
                "   ",
                "   "
            };
        World world = createWorld(worldString);
		Fire fire = FireFactory.createFire(0, 0, 0);
		fire.calcNewState(world);
	}
	
	@Test
	public void testCalcNewState6() {//Fire will be created in Water.-> isFireExtinguished  True

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
	public void testCalcNewState7() {//fire is Falling -> calcNewStateWhenFalling -> isRightRiseSlope True

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
	public void testCalcNewState8() {//fire is Falling -> calcNewStateWhenFalling -> isLeftRiseSlope True

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
	public void testCalcNewState9() {//isStill is true because someoneIsBridgingAt is true;

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
		int x = 2;
		int y = 2;
		World world = TextWorldManip.createEmptyWorld(2, 2);
		Fire fire = FireFactory.createFire(x, y, 0);	
		fire.step(world);
	}
	
	@Test
	public void testSaveState() {
		int x = 2;
		int y = 2;
		boolean runtimeMeta = false;
		World world = TextWorldManip.createEmptyWorld(2, 2);
		Fire fire = FireFactory.createFire(x, y, 0);	
		fire.saveState(runtimeMeta);
	}
	
	@Test
	public void testOverlayText() {
		int x = 2;
		int y = 2;

		World world = TextWorldManip.createEmptyWorld(2, 2);
		Fire fire = FireFactory.createFire(x, y, 0);	
		assertEquals(fire.overlayText(), "Fire");
	}


	

}
