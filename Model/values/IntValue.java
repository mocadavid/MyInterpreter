package Model.values;

import Model.types.IntType;
import Model.types.Type;

public class IntValue implements Value {

    private int value;

    public IntValue(int v){value=v;}
    public int getValue(){return value;}
    public void setValue(int newValue){ value = newValue; }
    public String toString(){return Integer.toString(value);}
    public Type getType(){ return new IntType();}
    public boolean equals(Object another){ return another instanceof IntValue; }
}
