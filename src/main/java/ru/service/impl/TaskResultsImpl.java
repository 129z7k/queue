package ru.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.queue.impl.SchedulerGet;
import ru.service.TaskResults;
import ru.task.Task;

@Service
public class TaskResultsImpl implements TaskResults {

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);

    @Override
    public void saveResult(Task t, Object result) {

        logger.warn("Сохранили результат выполнения задачи: "+t);

    }
}
