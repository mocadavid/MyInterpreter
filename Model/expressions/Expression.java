package Model.expressions;

import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.values.Value;

public interface Expression {
    Value evaluate(MyIDictionary<String,Value> table, MyIHeap<Integer,Value> heap);
    String toString();
}
