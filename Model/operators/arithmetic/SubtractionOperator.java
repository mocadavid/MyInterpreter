package Model.operators.arithmetic;

import Model.values.IntValue;
import Model.values.Value;

public class SubtractionOperator implements ArithmeticOperator{
    public Value computeArithmetic(IntValue leftValue, IntValue rightValue)
    { return new IntValue(leftValue.getValue()-rightValue.getValue()); }
    public String toString() { return "-"; }
}
