package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.values.Value;

public class VariableExpression implements Expression {
    private String id;
    public VariableExpression(String givenId){ id=givenId; }
    public Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap){
        if(table.isDefined(id)){ return table.getValue(id); }
        else{ throw new MyException("variable "+id+" is not defined"); }
    }
    public String toString(){ return id; }
}
