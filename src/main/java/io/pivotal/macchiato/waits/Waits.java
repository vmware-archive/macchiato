package io.pivotal.macchiato.waits;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

public class Waits {

    public static boolean throwsException(Runnable runnable) {
        try {
            runnable.run();
            return false;
        } catch (Exception e) {
           return true;
        }
    }

    public static void waitFor(Callable<Boolean> predicate, long timeout) throws Exception {
        long startTime = System.currentTimeMillis();

        while (!predicate.call()) {
            if (System.currentTimeMillis() - startTime < timeout) {
                Thread.sleep(500);
            } else {
                throw new TimeoutException();
            }
        }
    }

    public static void waitFor(Callable<Boolean> predicate) throws Exception {
        waitFor(predicate, 2000);
    }
}
