package Model;

import Model.collections.*;
import Model.statements.IStatement;
import Model.values.StringValue;
import Model.values.Value;

import java.io.BufferedReader;

public class ProgramState {

    private MyIStack<IStatement> executionStack;
    private MyIDictionary<String,Value> symbolTable;
    private MyIList<Value> output;
    private MyIDictionary<StringValue, BufferedReader> fileTable;
    private MyIHeap<Integer, Value> heap;
    private IStatement backup;


    public MyIStack<IStatement> getExecutionStack(){ return executionStack; }
    public MyIDictionary<String, Value> getSymbolTable(){ return symbolTable; }
    public MyIList<Value> getOutput(){ return output; }
    public MyIDictionary<StringValue, BufferedReader> getFileTable(){ return fileTable; }
    public MyIHeap<Integer, Value> getHeap(){ return heap; }
    public IStatement getBackup(){ return backup; }
    public void setExecutionStack(MyIStack<IStatement> newStack){executionStack=newStack;}
    public void setSymbolTable(MyIDictionary<String,Value> newTable){symbolTable=newTable;}
    public void setOutput(MyIList<Value> newList){ output=newList; }
    public void setFileTable(MyIDictionary<StringValue, BufferedReader> newFileTable){ fileTable=newFileTable; }
    public void setHeap(MyIHeap<Integer, Value> newHeap){ heap=newHeap; }

    public ProgramState(MyIStack<IStatement> exeStk,MyIDictionary<String,Value> symbTbl,MyIList<Value> outlist,
                        MyIDictionary<StringValue, BufferedReader> fileTbl, MyIHeap<Integer, Value> hp,
                        IStatement prg){
        executionStack=exeStk; symbolTable=symbTbl; output=outlist; fileTable=fileTbl; heap=hp;
        executionStack.push(prg); backup=prg;
    }

    public String toString(){
        String s1 = executionStack.toString();
        String s2 = symbolTable.toString();
        String s3 = output.toString();
        String s4 = heap.toString();
        return "["+s1 + "] [" + s2+"] [" + s3+"] ["+s4+"]";
    }


}
