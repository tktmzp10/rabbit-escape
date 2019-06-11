package rabbitescape.engine.things.items;

import org.junit.Test;

public class UnknownItemTypeExceptionTest {

    @Test(expected = UnknownItemTypeException.class)
    public void throwException() {
        throw new UnknownItemTypeException(BashItem.TYPE);
    }
}
