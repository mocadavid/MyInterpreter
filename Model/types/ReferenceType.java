package Model.types;

import Model.values.ReferenceValue;
import Model.values.Value;

public class ReferenceType implements Type {

    private Type inner;

    public ReferenceType(Type type){ inner=type; }
    public Type getInner(){ return inner; }

    public String toString(){ return "Ref("+inner.toString()+")"; }
    public boolean equals(Object another){
        if(another instanceof ReferenceType){
            return inner.equals(((ReferenceType) another).getInner());
        }else{ return false; }
    }
    public Value defaultValue(){ return new ReferenceValue(inner,0); }
}
