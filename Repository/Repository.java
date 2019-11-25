package Repository;

import Model.ProgramState;
import Model.collections.MyIDictionary;
import Model.collections.MyIHeap;
import Model.collections.MyIList;
import Model.collections.MyIStack;
import Model.exceptions.MyException;
import Model.statements.IStatement;
import Model.values.Value;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Repository implements IRepository{
    private MyIList<ProgramState> programs;
    private String logFilePath;

    public Repository(MyIList<ProgramState> p, String filePath){ programs=p; logFilePath=filePath; }

    public ProgramState getCurrentProgram(){
        if (!programs.isEmpty()){ return programs.get(0); }
        throw new MyException("No programs loaded");
    }

    public void logProgramStateExecution() {
        ProgramState program = getCurrentProgram();
        writeExecutionStack(program);
        writeSymbolTable(program);
        writeHeap(program);
        writeOutputList(program);
    }

    public void clearLogFile(){
        try(PrintWriter printWriter = new PrintWriter(logFilePath)){
            printWriter.println("-----------------------------------------------------\n");
        }
        catch (FileNotFoundException error){ throw new MyException(error.getMessage()); }
    }

    private void writeExecutionStack(ProgramState program){
        try(PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))){
            MyIStack<IStatement> executionStack = program.getExecutionStack();

            String executionStackAsString = executionStack.toString().substring(1,executionStack.toString().length()-1);
            String[] stackElementsAsStrng = executionStackAsString.split(",");
            Collections.reverse(Arrays.asList(stackElementsAsStrng));

            boolean firstElement = true;
            logFile.println("ExecutionStack\n");

            for(String element:stackElementsAsStrng){
                if(firstElement && stackElementsAsStrng.length>1){
                    logFile.println(element.substring(1));
                    firstElement=false;
                } else { logFile.println(element); }
            }
            logFile.println("------------------------------------------------------------------\n");
        }
        catch (IOException error){ throw new MyException(error.getMessage()); }
    }

    private void writeSymbolTable(ProgramState program){
        try(PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))) {
            MyIDictionary<String, Value> symbolTable = program.getSymbolTable();

            String symbolTableAsString = symbolTable.toString();
            String[] elementsAsString = symbolTableAsString.split(",");

            boolean firstElem = true;
            logFile.println("SymbolTable\n");

            for(String element:elementsAsString){
                if(symbolTable.size()<2){
                    logFile.println(element.substring(1,element.length()-1));
                }
                else if(symbolTable.size()>1 && firstElem){
                    logFile.println(element.substring(1));
                    firstElem=false;
                }
                else{
                    logFile.println(element.substring(1,element.length()-1));
                }
            }
            logFile.println("------------------------------------------------------------------\n");
        } catch (IOException error){ throw new MyException(error.getMessage()); }
    }


    private void writeOutputList(ProgramState program){
        try(PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))) {
            MyIList<Value> output = program.getOutput();

            String outputAsString = output.toString().substring(1,output.toString().length()-1);
            String[] elementsAsString = outputAsString.split(",");

            boolean firstElem = true;
            logFile.println("OutputList\n");

            for(String element: elementsAsString){
                if(firstElem){ logFile.println(element); firstElem=false; }
                else{ logFile.println(element.substring(1)); }
            }
            logFile.println("------------------------------------------------------------------\n");

        }catch (IOException error){ throw new MyException(error.getMessage()); }
    }

    private void writeHeap(ProgramState program){
        try(PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))) {
            MyIHeap<Integer, Value> heap = program.getHeap();

            String symbolTableAsString = heap.toString();
            String[] elementsAsString = symbolTableAsString.split(",");

            boolean firstElem = true;
            logFile.println("Heap\n");

            for(String element:elementsAsString){
                if(heap.size()<2){
                    logFile.println(element.substring(1,element.length()-1).replace("=","->"));
                }
                else if(heap.size()>1 && firstElem){
                    logFile.println(element.substring(1).replace("=","->"));
                    firstElem=false;
                }
                else{
                    logFile.println(element.substring(1,element.length()-1).replace("=","->"));
                }
            }
            logFile.println("------------------------------------------------------------------\n");
        } catch (IOException error){ throw new MyException(error.getMessage()); }
    }

}
