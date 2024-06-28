package com.philips.workshopcassandra.model.embedded;

import com.philips.workshopcassandra.model.enums.PropType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("prop")
public class Prop {

    private String name;
    private String value;
    private PropType type;

    public Prop(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PropType getType() {
        return type;
    }

    public void setType(PropType type) {
        this.type = type;
    }
}
