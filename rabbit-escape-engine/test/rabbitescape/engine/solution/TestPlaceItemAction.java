package rabbitescape.engine.solution;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.*;

public class TestPlaceItemAction {

    @Test
    public void Equal_actions_are_equal() {
        PlaceItemAction a1 = new PlaceItemAction(5, 4);
        PlaceItemAction a2 = new PlaceItemAction(5, 4);

        assertThat(a1, equalTo(a2));
        assertThat(a1.hashCode(), equalTo(a2.hashCode()));
    }

    @Test
    public void Different_actions_are_unequal() {
        PlaceItemAction a1 = new PlaceItemAction(5, 4);
        PlaceItemAction a2 = new PlaceItemAction(4, 5);

        assertThat(a1, not(equalTo(a2)));

        // Note: technically a correct hashCode could fail this, but it's
        //       desirable that in most cases it won't.
        assertThat(
            a1.hashCode(), not(equalTo(a2.hashCode())));
    }
}
