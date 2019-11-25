package com.company;

import Controller.Controller;
import Model.ProgramState;
import Model.collections.*;
import Model.expressions.*;
import Model.operators.arithmetic.AdditionOperator;
import Model.operators.arithmetic.ArithmeticOperator;
import Model.operators.arithmetic.MultiplicationOperator;
import Model.operators.arithmetic.SubtractionOperator;
import Model.operators.relational.GreaterOperator;
import Model.operators.relational.RelationalOperator;
import Model.statements.*;
import Model.types.*;
import Model.values.BoolValue;
import Model.values.IntValue;
import Model.values.StringValue;
import Model.values.Value;
import Repository.IRepository;
import Repository.Repository;
import View.ExitCommand;
import View.RunExampleCommand;
import View.TextMenu;

import java.io.BufferedReader;

public class Interpreter {

    public static void main(String[] args) {
        //first program
        IStatement ex1 = inputTestProgram1();
        MyIStack<IStatement> execStack1 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable1 = new MyDictionary<String, Value>();
        MyIList<Value> outputList1 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable1 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap1 = new HeapDictionary<Integer, Value>();

        ProgramState progState1 = new ProgramState(execStack1,symbTable1,outputList1,fileTable1,heap1,ex1);
        MyIList<ProgramState> listProg1 = new MyList<ProgramState>();
        listProg1.add(progState1);
        IRepository repo1 = new Repository(listProg1,"log1.txt");
        Controller controller1 = new Controller(repo1);

        //second program
        IStatement ex2 = inputTestProgram2();
        MyIStack<IStatement> execStack2 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable2 = new MyDictionary<String, Value>();
        MyIList<Value> outputList2 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable2 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap2 = new HeapDictionary<Integer, Value>();
        ProgramState progState2 = new ProgramState(execStack2,symbTable2,outputList2,fileTable2,heap2,ex2);
        MyIList<ProgramState> listProg2 = new MyList<ProgramState>();
        listProg2.add(progState2);
        IRepository repo2 = new Repository(listProg2,"log2.txt");
        Controller controller2 = new Controller(repo2);

        //third program
        IStatement ex3 = inputTestProgram3();
        MyIStack<IStatement> execStack3 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable3 = new MyDictionary<String, Value>();
        MyIList<Value> outputList3 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable3 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap3 = new HeapDictionary<Integer, Value>();
        ProgramState progState3 = new ProgramState(execStack3,symbTable3,outputList3,fileTable3,heap3,ex3);
        MyIList<ProgramState> listProg3 = new MyList<ProgramState>();
        listProg3.add(progState3);
        IRepository repo3 = new Repository(listProg3,"log3.txt");
        Controller controller3 = new Controller(repo3);

        //forth program
        IStatement ex4 = inputTestProgram4();
        MyIStack<IStatement> execStack4 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable4 = new MyDictionary<String, Value>();
        MyIList<Value> outputList4 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable4 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap4 = new HeapDictionary<Integer, Value>();
        ProgramState progState4 = new ProgramState(execStack4,symbTable4,outputList4,fileTable4,heap4,ex4);
        MyIList<ProgramState> listProg4 = new MyList<ProgramState>();
        listProg4.add(progState4);
        IRepository repo4 = new Repository(listProg4,"log4.txt");
        Controller controller4 = new Controller(repo4);

        //while program
        IStatement ex5 = inputTestProgramWhile();
        MyIStack<IStatement> execStack5 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable5 = new MyDictionary<String, Value>();
        MyIList<Value> outputList5 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable5 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap5 = new HeapDictionary<Integer, Value>();
        ProgramState progState5 = new ProgramState(execStack5,symbTable5,outputList5,fileTable5,heap5,ex5);
        MyIList<ProgramState> listProg5 = new MyList<ProgramState>();
        listProg5.add(progState5);
        IRepository repo5 = new Repository(listProg5,"log5.txt");
        Controller controller5 = new Controller(repo5);

        //heap allocation program
        IStatement ex6 = inputTestProgramHeapDeclaration();
        MyIStack<IStatement> execStack6 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable6 = new MyDictionary<String, Value>();
        MyIList<Value> outputList6 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable6 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap6 = new HeapDictionary<Integer, Value>();
        ProgramState progState6 = new ProgramState(execStack6,symbTable6,outputList6,fileTable6,heap6,ex6);
        MyIList<ProgramState> listProg6 = new MyList<ProgramState>();
        listProg6.add(progState6);
        IRepository repo6 = new Repository(listProg6,"log6.txt");
        Controller controller6 = new Controller(repo6);

        //heap reading program
        IStatement ex7 = inputTestProgramHeapReading();
        MyIStack<IStatement> execStack7 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable7 = new MyDictionary<String, Value>();
        MyIList<Value> outputList7 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable7 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap7 = new HeapDictionary<Integer, Value>();
        ProgramState progState7 = new ProgramState(execStack7,symbTable7,outputList7,fileTable7,heap7,ex7);
        MyIList<ProgramState> listProg7 = new MyList<ProgramState>();
        listProg7.add(progState7);
        IRepository repo7 = new Repository(listProg7,"log7.txt");
        Controller controller7 = new Controller(repo7);

        //heap writing program
        IStatement ex8 = inputTestProgramHeapWriting();
        MyIStack<IStatement> execStack8 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable8 = new MyDictionary<String, Value>();
        MyIList<Value> outputList8 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable8 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap8 = new HeapDictionary<Integer, Value>();
        ProgramState progState8 = new ProgramState(execStack8,symbTable8,outputList8,fileTable8,heap8,ex8);
        MyIList<ProgramState> listProg8 = new MyList<ProgramState>();
        listProg8.add(progState8);
        IRepository repo8 = new Repository(listProg8,"log8.txt");
        Controller controller8 = new Controller(repo8);

        //GARBAGE collector program
        IStatement ex9 = inputTestProgramGarbageCollector();
        MyIStack<IStatement> execStack9 =  new MyStack<IStatement>();
        MyIDictionary<String,Value> symbTable9 = new MyDictionary<String, Value>();
        MyIList<Value> outputList9 = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fileTable9 = new MyDictionary<StringValue,BufferedReader>();
        MyIHeap<Integer,Value> heap9 = new HeapDictionary<Integer, Value>();
        ProgramState progState9 = new ProgramState(execStack9,symbTable9,outputList9,fileTable9,heap9,ex9);
        MyIList<ProgramState> listProg9 = new MyList<ProgramState>();
        listProg9.add(progState9);
        IRepository repo9 = new Repository(listProg9,"log9.txt");
        Controller controller9 = new Controller(repo9);

        //View
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0","exit"));
        menu.addCommand(new RunExampleCommand("1",ex1.toString(),controller1));
        menu.addCommand(new RunExampleCommand("2",ex2.toString(),controller2));
        menu.addCommand(new RunExampleCommand("3",ex3.toString(),controller3));
        menu.addCommand(new RunExampleCommand("4",ex4.toString(),controller4));
        menu.addCommand(new RunExampleCommand("5",ex5.toString(),controller5));
        menu.addCommand(new RunExampleCommand("6",ex6.toString(),controller6));
        menu.addCommand(new RunExampleCommand("7",ex7.toString(),controller7));
        menu.addCommand(new RunExampleCommand("8",ex8.toString(),controller8));
        menu.addCommand(new RunExampleCommand("9",ex9.toString(),controller9));
        menu.show();
    }

    private static IStatement inputTestProgram1(){
        VariableExpression variableExpression = new VariableExpression("v");
        PrintStatement printStatement = new PrintStatement(variableExpression);
        IntValue intValue = new IntValue(2);
        ValueExpression valueExpression = new ValueExpression(intValue);
        AssignmentStatement assignmentStatement = new AssignmentStatement("v",valueExpression);
        CompoundStatement compoundStatement = new CompoundStatement(assignmentStatement,printStatement);
        IntType intType =new IntType();
        VariableDeclarationStatement variableDeclarationStatement = new VariableDeclarationStatement("v",intType);
        return new CompoundStatement(variableDeclarationStatement,compoundStatement);
    }

    private static IStatement inputTestProgram2(){
        VariableDeclarationStatement variableA = new VariableDeclarationStatement("a",new IntType());
        VariableDeclarationStatement variableB = new VariableDeclarationStatement("b",new IntType());
        ValueExpression valueExpr1 = new ValueExpression(new IntValue(1));
        ValueExpression valueExpr2 = new ValueExpression(new IntValue(2));
        ValueExpression valueExpr3 = new ValueExpression(new IntValue(3));
        ValueExpression valueExpr5 = new ValueExpression(new IntValue(5));
        ArithmeticOperator multiplication1 = new MultiplicationOperator();
        ArithmeticExpression ae1 = new ArithmeticExpression(valueExpr3,valueExpr5,multiplication1);
        ArithmeticOperator addition1 = new AdditionOperator();
        ArithmeticExpression ae2 = new ArithmeticExpression(valueExpr2,ae1,addition1);
        AssignmentStatement as1 = new AssignmentStatement("a",ae2);
        VariableExpression ve1 = new VariableExpression("a");
        ArithmeticOperator addition2 = new AdditionOperator();
        ArithmeticExpression ae3 = new ArithmeticExpression(ve1,valueExpr1,addition2);
        AssignmentStatement as2 = new AssignmentStatement("b",ae3);
        VariableExpression ve2 = new VariableExpression("b");
        PrintStatement printStatement = new PrintStatement(ve2);

        CompoundStatement cs1 = new CompoundStatement(as2,printStatement);
        CompoundStatement cs2 = new CompoundStatement(as1,cs1);
        CompoundStatement cs3 = new CompoundStatement(variableB,cs2);
        return new CompoundStatement(variableA,cs3);
    }

    private static IStatement inputTestProgram3(){
        VariableDeclarationStatement varA = new VariableDeclarationStatement("a",new BoolType());
        VariableDeclarationStatement varV = new VariableDeclarationStatement("v", new IntType());
        ValueExpression ve1 = new ValueExpression(new BoolValue(true));
        AssignmentStatement as1 = new AssignmentStatement("a",ve1);

        VariableExpression vare1 = new VariableExpression("v");
        PrintStatement printStatement = new PrintStatement(vare1);
        VariableExpression vare2 = new VariableExpression("a");

        ValueExpression ve2 = new ValueExpression(new IntValue(2));
        AssignmentStatement as22 =new AssignmentStatement("v",ve2);

        ValueExpression ve3 = new ValueExpression(new IntValue(3));
        AssignmentStatement as33 =new AssignmentStatement("v",ve3);

        IfStatement ifStatement = new IfStatement(vare2,as22,as33);

        CompoundStatement cs3 = new CompoundStatement(ifStatement,printStatement);
        CompoundStatement cs2 = new CompoundStatement(as1,cs3);
        CompoundStatement cs1 = new CompoundStatement(varV,cs2);
        return new CompoundStatement(varA,cs1);
    }

    private static IStatement inputTestProgram4(){
        IStatement stmt1 = new VariableDeclarationStatement("varf",new StringType());
        Expression valueExpr1 = new ValueExpression(new StringValue("test.in.txt"));
        IStatement assgn1 = new AssignmentStatement("varf",valueExpr1);
        Expression variableExpr1 = new VariableExpression("varf");
        IStatement openRFile = new OpenReadFileStatement(variableExpr1);

        IStatement stmt2 = new VariableDeclarationStatement("varc",new IntType());
        Expression variableExpr2 = new VariableExpression("varc");
        Expression variableExpr3 = new VariableExpression("varf");
        IStatement readFile1 = new ReadFileStatement(variableExpr3,variableExpr2);

        Expression printExpr1 = new VariableExpression("varc");
        IStatement printStmt = new PrintStatement(printExpr1);

        Expression variableExpr22 = new VariableExpression("varc");
        Expression variableExpr33 = new VariableExpression("varf");
        IStatement readFile11 = new ReadFileStatement(variableExpr33,variableExpr22);

        Expression printExpr11 = new VariableExpression("varc");
        IStatement printStmt2 = new PrintStatement(printExpr11);

        Expression closeExpr = new VariableExpression("varf");
        IStatement closeStmt = new CloseReadFileStatement(closeExpr);

        IStatement preStartStmt = new CompoundStatement(printStmt2,closeStmt);
        IStatement startStmt = new CompoundStatement(readFile11,preStartStmt);
        IStatement secondStmt = new CompoundStatement(printStmt,startStmt);
        IStatement thirdStmt = new CompoundStatement(readFile1,secondStmt);
        IStatement forthStmt = new CompoundStatement(stmt2,thirdStmt);
        IStatement preprefinal = new CompoundStatement(openRFile,forthStmt);
        IStatement prefinal = new CompoundStatement(assgn1,preprefinal);
        return new CompoundStatement(stmt1,prefinal);
    }

    private static IStatement inputTestProgramWhile(){
        IStatement vDeclaration = new VariableDeclarationStatement("v",new IntType());
        Value fourValue = new IntValue(4);
        Expression fourValueExpression = new ValueExpression(fourValue);
        IStatement vAssignment = new AssignmentStatement("v",fourValueExpression);

        Expression variableFromCond = new VariableExpression("v");
        Value zeroValue = new IntValue(0);
        Expression zeroExpression = new ValueExpression(zeroValue);
        RelationalOperator relOp = new GreaterOperator();
        Expression condition = new RelationalExpression(variableFromCond,zeroExpression,relOp);

        Expression whileVariableV = new VariableExpression("v");
        IStatement printStatementWhile = new PrintStatement(whileVariableV);

        Expression secondV = new VariableExpression("v");
        ArithmeticOperator minus = new SubtractionOperator();
        Value oneValue = new IntValue(1);
        Expression value1Expression = new ValueExpression(oneValue);
        Expression arithmetic =new ArithmeticExpression(secondV,value1Expression,minus);
        IStatement vNewValue = new AssignmentStatement("v",arithmetic);

        IStatement compundWhile = new CompoundStatement(printStatementWhile,vNewValue);
        IStatement whileStatement = new WhileStatement(condition,compundWhile);

        VariableExpression printExpression = new VariableExpression("v");
        IStatement printStatement = new PrintStatement(printExpression);

        IStatement preStartStmt = new CompoundStatement(whileStatement,printStatement);
        IStatement startStmt = new CompoundStatement(vAssignment,preStartStmt);
        return new CompoundStatement(vDeclaration,startStmt);
    }

    private static IStatement inputTestProgramHeapDeclaration(){
        Type refVType = new ReferenceType(new IntType());
        IStatement refV = new VariableDeclarationStatement("v",refVType);
        //declaration done
        Value value20 = new IntValue(20);
        Expression value20Expr = new ValueExpression(value20);
        IStatement heapDeclaration = new HeapAllocationStatement("v",value20Expr);
        //allocation done
        Type refAType = new ReferenceType(new ReferenceType(new IntType()));
        IStatement refA = new VariableDeclarationStatement("a",refAType);
        //declaration done
        Expression variableVExpr = new VariableExpression("v");
        IStatement heapDeclaration2 = new HeapAllocationStatement("a",variableVExpr);
        //allocation done
        Expression variableVPrint = new VariableExpression("v");
        IStatement print1 = new PrintStatement(variableVPrint);
        Expression variableAPrint = new VariableExpression("a");
        IStatement print2 = new PrintStatement(variableAPrint);
        //print done

        IStatement thirdStmt = new CompoundStatement(print1,print2);
        IStatement forthStmt = new CompoundStatement(heapDeclaration2,thirdStmt);
        IStatement preprefinal = new CompoundStatement(refA,forthStmt);
        IStatement prefinal = new CompoundStatement(heapDeclaration,preprefinal);
        return new CompoundStatement(refV,prefinal);
    }

    private static IStatement inputTestProgramHeapReading(){
        Type refVType = new ReferenceType(new IntType());
        IStatement refV = new VariableDeclarationStatement("v",refVType);
        //declaration done
        Value value20 = new IntValue(20);
        Expression value20Expr = new ValueExpression(value20);
        IStatement heapDeclaration = new HeapAllocationStatement("v",value20Expr);
        //allocation done
        Type refAType = new ReferenceType(new ReferenceType(new IntType()));
        IStatement refA = new VariableDeclarationStatement("a",refAType);
        //declaration done
        Expression variableVExpr = new VariableExpression("v");
        IStatement heapDeclaration2 = new HeapAllocationStatement("a",variableVExpr);
        //allocation done
        Expression varExprVPrint1 = new VariableExpression("v");
        Expression heapReadPrint1 = new HeapReadExpression(varExprVPrint1);
        IStatement printStatement1= new PrintStatement(heapReadPrint1);
        //first print done
        Expression varExprAPrint2 = new VariableExpression("a");
        Expression heapReadPrint22 = new HeapReadExpression(varExprAPrint2);
        Expression heapReadPrint2 = new HeapReadExpression(heapReadPrint22);

        Value fiveValue = new IntValue(5);
        Expression fiveValueExpression = new ValueExpression(fiveValue);
        ArithmeticOperator ao = new AdditionOperator();
        Expression arithmetic = new ArithmeticExpression(heapReadPrint2,fiveValueExpression,ao);

        IStatement printFirst = new PrintStatement(arithmetic);

        IStatement thirdStmt = new CompoundStatement(printStatement1,printFirst);
        IStatement forthStmt = new CompoundStatement(heapDeclaration2,thirdStmt);
        IStatement preprefinal = new CompoundStatement(refA,forthStmt);
        IStatement prefinal = new CompoundStatement(heapDeclaration,preprefinal);
        return new CompoundStatement(refV,prefinal);
    }

    private static IStatement inputTestProgramHeapWriting(){
        Type refVType = new ReferenceType(new IntType());
        IStatement refV = new VariableDeclarationStatement("v",refVType);
        //declaration done
        Value value20 = new IntValue(20);
        Expression value20Expr = new ValueExpression(value20);
        IStatement heapDeclaration = new HeapAllocationStatement("v",value20Expr);
        //allocation done
        Expression varExprVPrint1 = new VariableExpression("v");
        Expression heapReadPrint1 = new HeapReadExpression(varExprVPrint1);
        IStatement printStatement1= new PrintStatement(heapReadPrint1);
        //first print done
        Value value30 = new IntValue(30);
        Expression value30Expr = new ValueExpression(value30);
        IStatement writeHeap = new WriteHeapStatement("v",value30Expr);
        //write done
        Expression varExprVPrint2 = new VariableExpression("v");
        Expression heapReadPrint2 = new HeapReadExpression(varExprVPrint2);

        ArithmeticOperator ao = new AdditionOperator();
        Value value5 = new IntValue(5);
        Expression value5Expr = new ValueExpression(value5);

        Expression arithmetic = new ArithmeticExpression(heapReadPrint2,value5Expr,ao);
        IStatement printFinal = new PrintStatement(arithmetic);

        IStatement thirdStmt = new CompoundStatement(writeHeap,printFinal);
        IStatement forthStmt = new CompoundStatement(printStatement1,thirdStmt);
        IStatement preprefinal = new CompoundStatement(heapDeclaration,forthStmt);
        return new CompoundStatement(refV,preprefinal);
    }

    private static IStatement inputTestProgramGarbageCollector(){
        Type refVType = new ReferenceType(new IntType());
        IStatement refV = new VariableDeclarationStatement("v",refVType);
        //declaration done
        Value value20 = new IntValue(20);
        Expression value20Expr = new ValueExpression(value20);
        IStatement heapDeclaration = new HeapAllocationStatement("v",value20Expr);
        //allocation done
        Type refAType = new ReferenceType(new ReferenceType(new IntType()));
        IStatement refA = new VariableDeclarationStatement("a",refAType);
        //declaration done
        Expression variableVExpr = new VariableExpression("v");
        IStatement heapDeclaration2 = new HeapAllocationStatement("a",variableVExpr);
        //allocation done
        Value value30 = new IntValue(30);
        Expression value30Expr = new ValueExpression(value30);
        IStatement heapDeclaration3 = new HeapAllocationStatement("v",value30Expr);
        //allocation done
        Expression variableExpr = new VariableExpression("a");
        Expression readHeap1 = new HeapReadExpression(variableExpr);
        Expression readHeap2 = new HeapReadExpression(readHeap1);
        IStatement printStmt = new PrintStatement(readHeap2);

        IStatement thirdStmt = new CompoundStatement(heapDeclaration3,printStmt);
        IStatement forthStmt = new CompoundStatement(heapDeclaration2,thirdStmt);
        IStatement preprefinal = new CompoundStatement(refA,forthStmt);
        IStatement beforeFinal = new CompoundStatement(heapDeclaration,preprefinal);
        return new CompoundStatement(refV,beforeFinal);
    }

}
