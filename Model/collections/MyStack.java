package Model.collections;

import java.util.Iterator;
import java.util.Stack;


public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack;

    public MyStack(){ stack = new Stack<T>(); }

    public void push(T element){ stack.push(element); }
    public T pop(){
        return stack.pop();
    }
    public Iterator<T> iterator(){ return  stack.iterator(); }
    public boolean isEmpty(){ return stack.isEmpty(); }
    public String toString(){ return stack.toString(); }
    public int size(){ return stack.size(); }
}
