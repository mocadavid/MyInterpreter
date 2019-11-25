package Model.types;

import Model.values.StringValue;
import Model.values.Value;

public class StringType implements Type{
    public String toString(){ return "String"; }
    public boolean equals(Object another){ return another instanceof StringType; }
    public Value defaultValue(){ return new StringValue("None"); }
}
