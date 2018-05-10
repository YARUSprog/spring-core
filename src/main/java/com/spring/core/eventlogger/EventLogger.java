package com.spring.core.eventlogger;

import java.io.IOException;

import com.spring.core.Event;

public interface EventLogger {
    void logEvent(Event event) throws IOException;
}
