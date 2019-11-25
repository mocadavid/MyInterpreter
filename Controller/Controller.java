package Controller;

import Model.ProgramState;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.statements.IStatement;
import Model.values.ReferenceValue;
import Model.values.Value;
import Repository.IRepository;

import java.util.Collection;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private IRepository repository;

    public Controller(IRepository repo){ repository=repo; }

    private ProgramState oneStepExecution(ProgramState state){
        MyIStack<IStatement> stack = state.getExecutionStack();
        if(stack.isEmpty()){ throw new MyException("Execution stack is empty"); }
        IStatement currentStatement = stack.pop();
        return currentStatement.execute(state);
    }

    public void completeExecution(){
        ProgramState program = repository.getCurrentProgram();
        System.out.println(getDisplayProgramState(program));
        repository.clearLogFile();
        repository.logProgramStateExecution();
        while(!program.getExecutionStack().isEmpty()){
            oneStepExecution(program);
            repository.logProgramStateExecution();
            program.getHeap().setContent(safeGarbageCollector(getAddressesFromSymbolTable(program.getSymbolTable().getContent().values(),program.getHeap().getContent().values()),program.getHeap().getContent()));
            repository.logProgramStateExecution();
            System.out.println(getDisplayProgramState(program));
        }
    }

    private String getDisplayProgramState(ProgramState programState){ return programState.toString(); }

    private Map<Integer, Value> safeGarbageCollector(List<Integer> addressesFromSymbolTable, Map<Integer,Value> heap){
        return heap.entrySet().stream().filter(e->addressesFromSymbolTable.contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    private List<Integer> getAddressesFromSymbolTable(Collection<Value> symbolTableValues,Collection<Value> heap){
        return Stream.concat(heap.stream().filter(v->v instanceof ReferenceValue).map(v->{ReferenceValue v1=(ReferenceValue)v; return v1.getAddress();}),
                symbolTableValues.stream().filter(v->v instanceof ReferenceValue).map(v->{ReferenceValue v1 = (ReferenceValue)v; return v1.getAddress();})).collect(Collectors.toList());
    }

}
