package Model.types;

import Model.values.BoolValue;
import Model.values.Value;

public class BoolType implements Type{
    public boolean equals(Object another){
        return another instanceof BoolType;
    }
    public String toString(){
        return "bool";
    }
    public Value defaultValue(){ return new BoolValue(false); }
}
