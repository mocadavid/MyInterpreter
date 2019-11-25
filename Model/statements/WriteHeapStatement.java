package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.IntType;
import Model.values.ReferenceValue;
import Model.values.Value;

public class WriteHeapStatement implements IStatement {

    private String variableName;
    private Expression expression;

    public WriteHeapStatement(String varName, Expression expr){ expression=expr; variableName=varName; }

    public ProgramState execute(ProgramState state){
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIHeap<Integer, Value> heap = state.getHeap();

        if(symbolTable.isDefined(variableName)){
            Value variableValue = symbolTable.getValue(variableName);
            if(variableValue.equals(new ReferenceValue(new IntType(),0))){
                ReferenceValue variableReferenceValue = (ReferenceValue)variableValue;
                int address = variableReferenceValue.getAddress();
                if(heap.isDefined(address)){
                    Value expressionValue = expression.evaluate(symbolTable,heap);
                    if(variableReferenceValue.getLocationType().equals(expressionValue.getType())){
                        heap.update(address,expressionValue);
                        return state;
                    }else{ throw new MyException("Not matching types in heap"); }
                }else{ throw new MyException("Variable not defined in heap"); }
            }else{ throw new MyException("Variable: "+variableName+" is not of ref type"); }
        }else{ throw new MyException("Variable: "+variableName+" not defined"); }
    }

    public String toString(){ return "wH("+variableName+";"+expression.toString()+")"; }
}
