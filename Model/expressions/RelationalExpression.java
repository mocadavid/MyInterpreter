package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.operators.relational.RelationalOperator;
import Model.types.IntType;
import Model.values.IntValue;
import Model.values.Value;

public class RelationalExpression implements Expression{
    private Expression leftExpression;
    private Expression rightExpression;
    private RelationalOperator relationalOperator;

    public RelationalExpression(Expression left, Expression right, RelationalOperator operator)
    {leftExpression=left; rightExpression=right; relationalOperator=operator;}

    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        Value left = leftExpression.evaluate(table,heap);
        if(left.getType().equals(new IntType())){
            Value right = rightExpression.evaluate(table,heap);
            if(right.getType().equals(new IntType())){
                return relationalOperator.computeRelational((IntValue)left,(IntValue)right);
            }else{ throw new MyException("Second expresion has not an int type value"); }
        }else{ throw new MyException("First expresion has not an int type value"); }
    }
    public String toString(){
        return leftExpression.toString()+relationalOperator.toString()+rightExpression.toString();
    }
}
