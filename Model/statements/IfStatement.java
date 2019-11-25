package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.BoolType;
import Model.values.BoolValue;
import Model.values.Value;

public class IfStatement implements IStatement {

    private Expression expression;
    private IStatement thenStatement;
    private IStatement elseStatement;

    public IfStatement(Expression expr,IStatement thenS,IStatement elseS){
        expression=expr; thenStatement=thenS; elseStatement=elseS;
    }

    public Expression getExpression(){return expression;};
    public IStatement getThenStatement(){return thenStatement;};
    public IStatement getElseStatement(){ return elseStatement;};
    public void setExpression(Expression newExpression){ expression=newExpression;};
    public void setThenStatement(IStatement newThenStatement){thenStatement=newThenStatement;};
    public void setElseStatement(IStatement newElseStatement){elseStatement=newElseStatement;};

    public String toString(){
        return "If("+expression.toString()+") Then ("+thenStatement.toString()+") Else ("+elseStatement.toString()+")";
    }

    public ProgramState execute(ProgramState state){
        MyIStack<IStatement> executionStack = state.getExecutionStack();
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIHeap<Integer,Value> heap = state.getHeap();
        Value value = expression.evaluate(symbolTable,heap);

        if(value.getType().equals(new BoolType())){
            BoolValue condition = (BoolValue)value;

            if(condition.getValue()){
                executionStack.push(thenStatement);
                state.setExecutionStack(executionStack);
                return state; }
            else{
                executionStack.push(elseStatement);
                state.setExecutionStack(executionStack);
                return state; }
        } else { throw new MyException("Conditional expression is not a boolean expression"); }
    }

}

