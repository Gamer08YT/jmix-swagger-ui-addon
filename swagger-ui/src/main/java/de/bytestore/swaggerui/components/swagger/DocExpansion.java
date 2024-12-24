package de.bytestore.swaggerui.components.swagger;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum DocExpansion implements EnumClass<String> {

    NONE("none"),
    FULL("full"),
    LIST("list");

    private final String id;

    DocExpansion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static DocExpansion fromId(String id) {
        for (DocExpansion at : DocExpansion.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}