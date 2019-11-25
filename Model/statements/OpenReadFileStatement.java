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

import java.io.*;

public class OpenReadFileStatement implements IStatement {
    private Expression expression;

    public OpenReadFileStatement(Expression expr){ expression=expr; }

    public ProgramState execute(ProgramState state){
        MyIStack<IStatement> executionStack = state.getExecutionStack();
        MyIDictionary<String,Value> symbolTable = state.getSymbolTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer,Value> heap = state.getHeap();

        Value value=expression.evaluate(symbolTable,heap);
        if(value.getType().equals(new StringType())){
            if(!fileTable.isDefined((StringValue)value)){
                try{
                    File theFile = new File(((StringValue) value).getValue());//i
                    Reader reader = new FileReader(theFile);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    fileTable.update((StringValue)value,bufferedReader);
                    state.setExecutionStack(executionStack);
                    state.setFileTable(fileTable);
                    return state;
                }catch (FileNotFoundException error){ throw new MyException(error.getMessage()); }
            }else{ throw new MyException("File already open"); }
        }else{ throw new MyException("Expression does not have a string type value"); }
    }

    public String toString(){
        return "openRFile("+expression.toString()+")";
    }
}
