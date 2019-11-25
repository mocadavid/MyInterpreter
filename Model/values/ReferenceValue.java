package Model.values;

import Model.types.ReferenceType;
import Model.types.Type;

public class ReferenceValue implements Value {
    private int address;
    private Type locationType;

    public ReferenceValue(Type type,int add){ locationType=type; address=add; }
    public int getAddress(){ return address; }
    public Type getLocationType(){ return locationType; }
    public void setAddress(int newAddress){ address=newAddress; }
    public void setLocationType(Type newType){ locationType=newType; }
    public Type getType(){ return new ReferenceType(locationType); }
    public String toString(){ return "("+locationType.toString()+";"+ address +")"; }
    public boolean equals(Object another){ return another instanceof ReferenceValue; }
}
