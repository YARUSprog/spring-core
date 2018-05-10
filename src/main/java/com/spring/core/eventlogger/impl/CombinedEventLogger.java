package com.spring.core.eventlogger.impl;

import java.io.IOException;
import java.util.List;

import com.spring.core.Event;
import com.spring.core.eventlogger.EventLogger;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(final List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(final Event event) throws IOException {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
