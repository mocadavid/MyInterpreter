package Model.types;

import Model.values.Value;

public interface Type {
    String toString();
    boolean equals(Object another);
    Value defaultValue();
}
