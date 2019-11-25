package Model.operators.logic;

import Model.values.BoolValue;
import Model.values.Value;

public interface LogicOperator {
    Value computeLogic(BoolValue leftValue, BoolValue rightValue);
    String toString();
}
