package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.operators.arithmetic.ArithmeticOperator;
import Model.types.IntType;
import Model.values.IntValue;
import Model.values.Value;

public class ArithmeticExpression implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;
    private ArithmeticOperator arithmeticOperator;

    public ArithmeticExpression(Expression left,Expression right,ArithmeticOperator operator)
    { leftExpression =left; rightExpression =right; arithmeticOperator=operator; }

    public Expression getFirstExpression(){ return leftExpression; };
    public Expression getSecondExpression(){ return rightExpression; };
    public ArithmeticOperator getOperator(){ return arithmeticOperator; };
    public void setFirstExpression(Expression newExpression){ leftExpression =newExpression;};
    public void setSecondExpression(Expression newExpression){ rightExpression =newExpression;};
    public void setOperator(ArithmeticOperator newOperator){ arithmeticOperator=newOperator;};

    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        Value leftValue= leftExpression.evaluate(table,heap);
        if(leftValue.getType().equals(new IntType())){
            Value rightValue = rightExpression.evaluate(table,heap);
            if(rightValue.getType().equals(new IntType())){
                return arithmeticOperator.computeArithmetic((IntValue)leftValue,(IntValue)rightValue);
            }else{ throw new MyException("Second operand is not an integer"); }
        }else{ throw new MyException("First operand is not an integer"); }
    }

    public String toString(){
        return leftExpression.toString()+arithmeticOperator.toString()+rightExpression.toString();
    }

}

