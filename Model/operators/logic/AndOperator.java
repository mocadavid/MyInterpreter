package Model.operators.logic;

import Model.values.BoolValue;
import Model.values.Value;

public class AndOperator implements LogicOperator {
    public Value computeLogic(BoolValue leftValue, BoolValue rightValue){
        boolean left = leftValue.getValue();
        boolean right = rightValue.getValue();
        boolean result = left && right;
        return new BoolValue(result);
    }
    public String toString(){ return "&&"; }
}
