package com.spring.core.eventlogger.impl;

import java.io.File;
import java.io.IOException;

import com.spring.core.Event;
import com.spring.core.eventlogger.EventLogger;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

    private String fileName;

    public FileEventLogger(final String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        (new File(fileName)).canWrite();
    }

    public void logEvent(final Event event) throws IOException {
        FileUtils.writeStringToFile(new File(fileName), event.toString(), true);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
}
