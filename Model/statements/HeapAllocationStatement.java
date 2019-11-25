package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.IntType;
import Model.types.ReferenceType;
import Model.types.Type;
import Model.values.ReferenceValue;
import Model.values.Value;

public class HeapAllocationStatement implements IStatement {
    private String variableName;
    private Expression expression;

    public HeapAllocationStatement(String varName,Expression expr){ variableName=varName; expression=expr; }

    public ProgramState execute(ProgramState state){
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        if(symbolTable.isDefined(variableName)){
            Value variableValue = symbolTable.getValue(variableName);
            if(variableValue.equals(new ReferenceValue(new IntType(),0))){
                ReferenceValue variableReferenceValue = (ReferenceValue)variableValue;
                Value expressionValue = expression.evaluate(symbolTable,heap);
                Type expressionType = expressionValue.getType();
                Type locationType = variableReferenceValue.getLocationType();
                if(locationType.equals(expressionType)){
                    heap.update(heap.getFreeAddress(),expressionValue);
                    variableReferenceValue.setAddress(heap.getFreeAddress());
                    symbolTable.update(variableName,variableReferenceValue);
                    heap.setFreeAddress(heap.getFreeAddress()+1);
                    return state;
                }else{ throw new MyException("Reference types do not match"); }
            }else{ throw new MyException("Variable: "+variableName+"'s value is not a RefValue "); }
        }else{ throw new MyException("Variable: "+variableName+" is not defined"); }
    }

    public String toString(){ return "new("+variableName.toString()+";"+expression.toString()+")"; }
}
