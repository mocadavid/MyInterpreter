package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.IntType;
import Model.types.StringType;
import Model.values.IntValue;
import Model.values.StringValue;
import Model.values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStatement implements IStatement{

    private Expression expression;
    private Expression variable;   //not sure expression maybe not string value

    public ReadFileStatement(Expression expr,Expression varName){ expression=expr; variable=varName; }

    public ProgramState execute(ProgramState state){
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        MyIHeap<Integer,Value> heap = state.getHeap();

        Value variableValue = variable.evaluate(symbolTable,heap);
        if(!variableValue.getType().equals(new IntType())){ throw new MyException("Variable is not of type int"); }
        Value expressionValue = expression.evaluate(symbolTable,heap);
        if(expressionValue.getType().equals(new StringType())){
            if(fileTable.isDefined((StringValue)expressionValue)){
                BufferedReader bufferedReader = fileTable.getValue((StringValue) expressionValue);
                try{
                    String line = bufferedReader.readLine();
                    if(line!=null){
                        Value valueFromFile = new IntValue(Integer.parseInt(line));
                        symbolTable.update(variable.toString(),valueFromFile);
                        state.setSymbolTable(symbolTable);
                        return state;
                    }else{
                        Value valueFromFile = new IntValue(0);
                        symbolTable.update(variable.toString(),valueFromFile);
                        state.setSymbolTable(symbolTable);
                        return state;
                    }
                }catch (IOException err){ throw new MyException(err.getMessage()); }
            }else{ throw new MyException("There is no entry for the given name in the file table"); }
        }else{ throw new MyException("The file path is not of type String"); }
    }

    public String toString(){
        return "readFile("+expression.toString()+";"+ variable +")";
    }
}
