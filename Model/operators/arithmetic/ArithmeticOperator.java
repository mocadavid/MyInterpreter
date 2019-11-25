package Model.operators.arithmetic;

import Model.values.IntValue;
import Model.values.Value;

public interface ArithmeticOperator {
    Value computeArithmetic(IntValue leftValue, IntValue rightValue);
    String toString();
}
