package rabbitescape.engine.logic;

import static rabbitescape.engine.util.WorldAssertions.*;

import org.junit.Test;

public class TestExploding {

    /**
     * Purpose: To test rabbit explodes when picks up explode item.
     * Input:
     * World maps instances that rabbit picks up explode item.
     * Expected: Rabbit instance is to be eliminated.
     */
    @Test
    public void Rabbit_explodes_when_picks_up_item() {
        assertWorldEvolvesLike(
            " rp " + "\n" +
                "####",

            "  P " + "\n" +
                "####",

            "    " + "\n" +
                "####"
        );
    }
}
