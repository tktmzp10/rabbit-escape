package rabbitescape.engine.things.items;

import org.junit.Test;

public class UnknownCharRepresentationExceptionTest {

    @Test(expected = UnknownCharRepresentationException.class)
    public void throwException() {
        throw new UnknownCharRepresentationException();
    }
}
