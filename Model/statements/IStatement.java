package Model.statements;

import Model.ProgramState;

public interface IStatement {
    ProgramState execute(ProgramState state);
    String toString();
}
