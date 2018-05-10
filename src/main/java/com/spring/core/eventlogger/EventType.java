package com.spring.core.eventlogger;

public enum EventType {
    INFO("INFO"), ERROR("ERROR");

    private final String value;

    EventType(final String v) {
        this.value = v;
    }

    public String value() {
        return value;
    }

    public static EventType fromValue(String v) {
        for (EventType c: EventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
