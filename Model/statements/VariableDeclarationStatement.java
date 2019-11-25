package Model.statements;

import Model.ProgramState;
import Model.collections.MyIDictionary;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.types.*;
import Model.values.BoolValue;
import Model.values.IntValue;
import Model.values.Value;

public class VariableDeclarationStatement implements IStatement{
    private Type type;
    private String name;

    public VariableDeclarationStatement(String n,Type t){ name=n; type=t; }
    public String getName(){ return name;}
    public Type getType(){ return type;}
    public void setName(String newName){ name=newName;}
    public void setType(Type newType){ type=newType;}
    public String toString(){ return ""+type.toString()+" "+name+"";  }

    public ProgramState execute(ProgramState state){
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();

        if(symbolTable.isDefined(name)){
            throw new MyException("Variable already defined"); }
        else{
            symbolTable.update(name,type.defaultValue());
            state.setSymbolTable(symbolTable);
            return state;
        }

    }

}
