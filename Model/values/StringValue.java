package Model.values;

import Model.types.StringType;
import Model.types.Type;

public class StringValue implements Value {
    private String value;

    public StringValue(String v){ value=v; }
    public String getValue(){ return value; }
    public void setValue(String newValue){ value = newValue; }
    public Type getType(){ return new StringType(); }
    public String toString(){ return value; }
    public boolean equals(Object another){ return another instanceof StringValue; };
}
