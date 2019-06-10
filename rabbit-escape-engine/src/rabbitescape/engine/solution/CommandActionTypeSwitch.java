package rabbitescape.engine.solution;

public interface CommandActionTypeSwitch {

    void caseWaitAction(WaitAction waitAction);

    void caseSelectAction(SelectAction selectAction);

    void caseAssertStateAction(AssertStateAction targetStateAction)
        throws SolutionExceptions.UnexpectedState;

    void casePlaceItemAction(PlaceItemAction placeItemAction);

    void caseUntilAction(UntilAction untilAction);
}
