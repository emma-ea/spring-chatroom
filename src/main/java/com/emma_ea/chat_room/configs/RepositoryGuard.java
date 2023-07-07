package com.emma_ea.chat_room.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class RepositoryGuard {

    static Logger logger = LoggerFactory.getLogger(RepositoryGuard.class);

    /**
     * guardRepoAccess wrap all calls to repository layer
     * provides a central place for handling exceptions
     * @param func - repository function being called
     * @param <T> - repository function call return type
     * @return T
     */
    public static <T> T guardRepoAccess(Callable<T> func) {
        try {
            return func.call();
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
