package com.skye8.elroykanye.hyrrebus.data.entity.enums;

public enum BusType {
    PREMIUM("premium"),
    STANDARD("standard"),
    COASTAL("coastal");

    private final String typeName;

    BusType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
    public BusType getBusType(String typeName) {
        for (BusType type : BusType.values()) {
            if (type.name().equals(typeName)) {
                return type;
            }
        }
        return null;
    }
}
