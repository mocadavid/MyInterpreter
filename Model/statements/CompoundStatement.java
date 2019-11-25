package Model.statements;

import Model.ProgramState;
import Model.collections.MyIStack;

public class CompoundStatement implements IStatement {
    private IStatement first;
    private IStatement second;

    public CompoundStatement(IStatement f,IStatement s){ first=f; second=s; }

    public IStatement getFirstIStatement(){ return first;};
    public IStatement getSecondIStatement(){ return second;};

    public void setFirstIStatement(IStatement newStatement){ first=newStatement;};
    public void setSecondIStatement(IStatement newStatement){ second =newStatement;};

    public ProgramState execute(ProgramState state){
        MyIStack<IStatement> stack = state.getExecutionStack();
        stack.push(second);
        stack.push(first);
        return state;
    }

    public String toString(){
        return ""+first.toString()+";"+second.toString()+"";
    }
}
