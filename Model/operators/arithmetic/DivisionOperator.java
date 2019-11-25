package Model.operators.arithmetic;

import Model.exceptions.MyException;
import Model.values.IntValue;
import Model.values.Value;

public class DivisionOperator implements ArithmeticOperator {
    public Value computeArithmetic(IntValue leftValue, IntValue rightValue){
        if(rightValue.getValue()==0){ throw new MyException("Division by zero"); }
        return new IntValue(leftValue.getValue()/rightValue.getValue());
    }
    public String toString() { return "/"; }
}
