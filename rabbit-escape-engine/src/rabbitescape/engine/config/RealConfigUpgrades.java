package rabbitescape.engine.config;

import rabbitescape.engine.config.upgrades.UpgradeTo01NonAndroidDummy;
import rabbitescape.engine.config.upgrades.UpgradeTo02LevelsCompletedByName;

public class RealConfigUpgrades {

    /**
     * Create the standard list of upgrades for non-Android versions, including a dummy empty
     * upgrade from version 0 to 1.
     *
     * @return the list of currently-enabled config upgrades. The first upgrades from version 0 to
     * 1, the second upgrades from version 1 to 2, etc.
     */
    public static IConfigUpgrade[] realConfigUpgrades() {
        return realConfigUpgrades(new UpgradeTo01NonAndroidDummy());
    }

    public static IConfigUpgrade[] realConfigUpgrades(
        IConfigUpgrade upgradeTo1) {
        return new IConfigUpgrade[]
            {
                upgradeTo1,
                new UpgradeTo02LevelsCompletedByName()
            };
    }
}
