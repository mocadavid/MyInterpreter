package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.types.IntType;
import Model.values.ReferenceValue;
import Model.values.Value;

public class HeapReadExpression implements Expression {

    private Expression expression;

    public HeapReadExpression(Expression expr){ expression=expr; }

    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        Value expressionValue = expression.evaluate(table,heap);
        if(expressionValue.equals(new ReferenceValue(new IntType(),0))){
            ReferenceValue expressionReferenceValue = (ReferenceValue)expressionValue;
            int address = expressionReferenceValue.getAddress();
            if(heap.isDefined(address)){
                return heap.getValue(address);
            }else{ throw new MyException("Invalid address from heap"); }
        }else{ throw new MyException("Expression's value is not a Reference value"); }
    }

    public String toString(){ return "rH("+expression.toString()+")"; }
}
