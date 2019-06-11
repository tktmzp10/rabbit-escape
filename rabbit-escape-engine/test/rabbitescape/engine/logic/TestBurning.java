package rabbitescape.engine.logic;

import org.junit.Test;
import rabbitescape.engine.World;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static rabbitescape.engine.textworld.TextWorldManip.createWorld;

public class TestBurning {

    /**
     * Purpose: To test rabbit is dying when it meets fire on ground
     * Input:
     * steps to reach death = 4
     * World maps
     * "      "
     * " r  A "
     * "######"
     * Expected: Rabbit dies exactly after four steps.
     */
    @Test
    public void Burning_normal_test(){
        assertRabbitDeadAfter( 4,
            "      ",
            " r  A ",
            "######"
        );
    }

    private void assertRabbitDeadAfter(int stepsToDeath, String... worldLines) {
        World world = createWorld(worldLines);

        for (int i = 1; i < stepsToDeath; ++i) {
            world.step();
            assertThat(world.num_killed, equalTo(0));
        }

        world.step();
        assertThat(world.num_killed, equalTo(1));
    }
}
