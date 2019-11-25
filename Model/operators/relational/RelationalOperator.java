package Model.operators.relational;

import Model.values.IntValue;
import Model.values.Value;

public interface RelationalOperator {
    Value computeRelational(IntValue leftValue, IntValue rightValue);
    String toString();
}
