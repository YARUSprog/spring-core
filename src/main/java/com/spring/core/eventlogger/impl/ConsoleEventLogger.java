package com.spring.core.eventlogger.impl;

import com.spring.core.Event;
import com.spring.core.eventlogger.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
