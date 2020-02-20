package com.contactsunny.poc.PojoEntityExtensionPOC.eventListener;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.util.Date;

public class MongoDBBeforeSaveEventListener extends AbstractMongoEventListener<Object> {

    private static Logger logger = LogManager.getLogger(MongoDBBeforeSaveEventListener.class);

    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {

        Document eventObject = event.getDocument();

        if (eventObject != null) {
            if (eventObject.containsKey("createdAt")) {
                if (eventObject.getLong("createdAt") == 0) {
                    eventObject.put("createdAt", new Date().getTime());
                }
            }

            eventObject.put("updatedAt", new Date().getTime());

            logger.info("DB Object: " + new Gson().toJson(eventObject));
        }

        super.onBeforeSave(event);
    }
}
