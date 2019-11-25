package Model.values;

import Model.types.Type;

public interface Value {
    Type getType();
    String toString();
    boolean equals(Object another);
}
