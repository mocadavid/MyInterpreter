package Model.values;

import Model.types.BoolType;
import Model.types.Type;

public class BoolValue implements Value {

    private boolean value;

    public BoolValue(boolean v){value=v;}
    public boolean getValue(){return value;}
    public void setValue(boolean newValue){ value=newValue; }
    public String toString(){return Boolean.toString(value);}
    public Type getType(){ return new BoolType();}
    public boolean equals(Object another){ return another instanceof BoolValue; }

    public Value logicalAnd(BoolValue boolValue){
        boolean bool2;
        bool2=boolValue.getValue();
        boolean result = value && bool2;
        return new BoolValue(result);
    }

    public Value logicalOr(BoolValue boolValue){
        boolean bool2;
        bool2=boolValue.getValue();
        boolean result = value || bool2;
        return new BoolValue(result);
    }



}

