package Model.operators.relational;

import Model.values.BoolValue;
import Model.values.IntValue;
import Model.values.Value;

public class EqualOperator implements RelationalOperator {
    public Value computeRelational(IntValue leftValue, IntValue rightValue)
    { return new BoolValue(leftValue.getValue()==rightValue.getValue());}
    public String toString(){ return "=="; }
}
