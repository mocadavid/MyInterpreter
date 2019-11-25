package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.expressions.Expression;
import Model.types.BoolType;
import Model.values.BoolValue;
import Model.values.Value;
import Model.exceptions.MyException;

public class WhileStatement implements IStatement {

    private Expression expression;
    private IStatement statement;

    public WhileStatement(Expression expr, IStatement stmt){expression=expr; statement=stmt;}

    public ProgramState execute(ProgramState state){

        MyIStack<IStatement> stack = state.getExecutionStack();
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIHeap<Integer,Value> heap = state.getHeap();

        Value value = expression.evaluate(symbolTable,heap);

        if(value.getType().equals(new BoolType())){
            BoolValue boolValue = (BoolValue) value;
            if(boolValue.getValue()){
                stack.push(this);
                stack.push(statement);
                return state;
            }else{
                return state;
            }
        }else{ throw new MyException("Condition expression is not of bool type"); }
    }

    public String toString(){
        return "(while("+expression.toString()+")"+statement.toString()+")";
    }
}
