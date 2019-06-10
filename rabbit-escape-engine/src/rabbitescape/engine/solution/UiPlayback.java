package rabbitescape.engine.solution;

/**
 * Interface for GeneralPhysics to initiate actions for demo mode.
 *
 * @see SolutionInterpreter
 */
public interface UiPlayback {

    void selectItem(SelectAction selectAction);

    void placeItem(PlaceItemAction placeItemAction);
}
