package com.spring.core;

import java.io.IOException;
import java.util.Map;

import com.spring.core.eventlogger.EventLogger;
import com.spring.core.eventlogger.EventType;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static final String CONTEXT_FILE = "spring-context.xml";

    private Client client;
    private EventLogger cacheFileEventLogger;
    private Map map;

    private static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_FILE);

    public App() {
    }

    public App(final Client client, final EventLogger cacheFileEventLogger, Map map) {
        this.client = client;
        this.cacheFileEventLogger = cacheFileEventLogger;
        this.map = map;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public void logEvent(String msg, EventType eventType) throws IOException {
        String message = msg.replaceAll(client.getId().toString(), client.getName());
        Event event = context.getBean(Event.class);
        event.setMessge(message);

        EventLogger logger = (EventLogger) map.get(eventType);
        if(logger == null){
            logger = cacheFileEventLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(CONTEXT_FILE);
        App app = context.getBean("app", App.class);
        app.logEvent("Some event for user 1", EventType.INFO);
        app.logEvent("Some event for user 2", EventType.INFO);
        app.logEvent("Some event for user 3", EventType.INFO);
        app.logEvent("Some event for user 4", EventType.INFO);
        app.logEvent("Some event for user 5", EventType.INFO);
        app.logEvent("Some event for user 6", EventType.INFO);
        app.logEvent("Some event for user 7", EventType.INFO);
        app.logEvent("Some event for user 8", EventType.INFO);
        app.logEvent("Some event for user 9", EventType.INFO);
        app.logEvent("Some event for user 10", EventType.INFO);
//        app.logEvent("Some event for user 11", EventType.INFO);
        context.registerShutdownHook();
    }
}
