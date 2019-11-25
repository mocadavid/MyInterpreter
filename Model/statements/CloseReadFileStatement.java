package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.StringType;
import Model.values.StringValue;
import Model.values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseReadFileStatement implements IStatement {

    private Expression expression;

    public CloseReadFileStatement(Expression expr){ expression=expr; }

    public ProgramState execute(ProgramState state){
        MyIStack<IStatement> executionStack = state.getExecutionStack();
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer,Value> heap = state.getHeap();

        Value value=expression.evaluate(symbolTable,heap);
        if(value.getType().equals(new StringType())){
            if(fileTable.isDefined((StringValue)value)){
                BufferedReader bufferedReader = fileTable.getValue((StringValue)value);
                try{ bufferedReader.close(); } catch (IOException err){ throw new MyException(err.getMessage()); }
                fileTable.remove((StringValue)value);
                state.setExecutionStack(executionStack);
                state.setFileTable(fileTable);
                return state;
            }else{ throw new MyException("File is not open"); }
        }else{ throw new MyException("Expression does not have a string type value"); }
    }

    public String toString(){ return "closeRFile("+expression.toString()+")"; }
}
