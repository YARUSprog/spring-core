package com.spring.core.eventlogger.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.spring.core.Event;

public class CacheFileEventLogger extends FileEventLogger {

    private Integer cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(final String fileName, final Integer cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    public void logEvent(final Event event) throws IOException {
        cache.add(event);
        writeCacheToFile();
    }

    private void writeCacheToFile() throws IOException {
        if(cache.size() == cacheSize){
            for (Event eventObj : cache) {
                super.logEvent(eventObj);
            }
            cache.clear();
        }
    }

    private void destroy() throws IOException {
        if(!cache.isEmpty()){
            writeCacheToFile();
        }
    }
}
