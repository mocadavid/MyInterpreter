package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.operators.logic.LogicOperator;
import Model.types.BoolType;
import Model.values.BoolValue;
import Model.values.Value;

public class LogicExpression implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;
    private LogicOperator logicOperator;

    public LogicExpression(Expression left,Expression right,LogicOperator operator)
    { leftExpression =left; rightExpression =right; logicOperator=operator; }

    public Expression getFirstExpression(){ return leftExpression; }
    public Expression getSecondExpression(){ return rightExpression; }
    public LogicOperator getOperand(){ return logicOperator; }
    public void setFirstExpression(Expression newExpression){ leftExpression =newExpression;}
    public void setSecondExpression(Expression newExpression){ rightExpression =newExpression;}
    public void setOperand(LogicOperator newOperator){ logicOperator=newOperator;}


    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        Value leftValue= leftExpression.evaluate(table,heap);
        if(leftValue.getType().equals(new BoolType())){
            Value rightValue = rightExpression.evaluate(table,heap);
            if(rightValue.getType().equals(new BoolType())){
                return logicOperator.computeLogic((BoolValue)leftValue,(BoolValue)rightValue);
            }else{ throw new MyException("Operarand 2 is not boolean"); }
        }else{ throw new MyException("Operarand 1 is not boolean"); }
    }

    public String toString() {
        return leftExpression.toString()+logicOperator.toString()+rightExpression.toString();
    }

}

