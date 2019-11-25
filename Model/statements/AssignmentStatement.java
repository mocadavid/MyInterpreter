package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.expressions.Expression;
import Model.types.Type;
import Model.values.Value;

public class AssignmentStatement implements IStatement{

    private String id;
    private Expression expression;

    public AssignmentStatement(String i,Expression expr){ id=i; expression=expr; }

    public String getId(){return id;};
    public Expression getExpression(){ return expression;};
    public void setId(String newId){ id=newId;};
    public void setExpression(Expression newExpression){ expression=newExpression;};

    public String toString(){
        return ""+id+"="+ expression.toString()+"";
    }

    public ProgramState execute(ProgramState state){

        MyIStack<IStatement> stack = state.getExecutionStack();
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIHeap<Integer,Value> heap = state.getHeap();
        Value value = expression.evaluate(symbolTable,heap);

        if(symbolTable.isDefined(id)){
            Type typeId = (symbolTable.getValue(id)).getType();

            if(value.getType().equals(typeId)){ symbolTable.update(id,value); }
            else throw new MyException("Declared type of variable "+id+" and type of assignment operator do not match");

        } else throw new MyException("The used variable "+id+" was not declared before");

        return state;
    }
}

