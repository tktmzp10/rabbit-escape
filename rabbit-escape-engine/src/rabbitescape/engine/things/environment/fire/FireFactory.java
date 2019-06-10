package rabbitescape.engine.things.environment.fire;

import rabbitescape.engine.things.environment.Fire;

public class FireFactory {

    private FireFactory() {

    }

    public static Fire createFire(int x, int y, int variant) {
        switch (variant) {
            case 0:
                return new Fire_A(x, y);
            case 1:
                return new Fire_B(x, y);
            case 2:
                return new Fire_C(x, y);
            case 3:
                return new Fire_D(x, y);
        }
        throw new RuntimeException(
            "Variant outside expected range (0 - 3):" + variant);
    }
}
