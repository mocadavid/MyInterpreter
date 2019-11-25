package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.values.Value;

public class ValueExpression implements Expression {
    private Value value;

    public ValueExpression(Value v){ value=v; }
    public Value getValue(){ return value;}
    public void setValue(Value newValue){ value =newValue; }
    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        return value;
    }
    public String toString(){ return value.toString(); }
}
