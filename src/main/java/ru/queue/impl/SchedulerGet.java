package ru.queue.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.queue.Queue;
import ru.task.Task;

@Component
public class SchedulerGet {

    @Autowired
    Queue queue;

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);

    /**
     * The method is called on a schedule, receives tasks and logs them
     * @exception IllegalStateException
     */
    @Scheduled(fixedRateString = "${scheduledtimeout}")
    public boolean GetTaskFromQueue() {
        queue.connect();
        try {
            while (queue.haveTasks()) {
                Task currentTask = queue.getNextTask();
                logger.warn(""+currentTask);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
        queue.disconnect();
        return true;
    }
}
