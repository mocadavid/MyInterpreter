package Model.statements;

import Model.ProgramState;
import Model.collections.HeapDictionary;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIList;
import Model.expressions.Expression;
import Model.values.Value;

public class PrintStatement implements IStatement {
    private Expression expression;

    public PrintStatement(Expression expr) { expression = expr; }

    public Expression getExpression(){ return expression; }
    public void setExpression(Expression newExpression){ expression=newExpression;}

    public ProgramState execute(ProgramState state) {
        MyIDictionary<String, Value> symbolTable = state.getSymbolTable();
        MyIList<Value> output=state.getOutput();
        MyIHeap<Integer,Value> heap = state.getHeap();

        Value value = expression.evaluate(symbolTable,heap);
        output.add(value);
        state.setOutput(output);

        return state;
    }

    public String toString() {
        return "print(" + expression.toString() + ")";
    }

}
