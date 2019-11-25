package Model.statements;

import Model.ProgramState;

public class NopStatement implements IStatement {

    public ProgramState execute(ProgramState state) { return state; }
    public String toString(){ return ""; }

}
