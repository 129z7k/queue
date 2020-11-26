package ru.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.queue.impl.SchedulerGet;
import ru.service.Task1Service;
import ru.service.TaskResults;
import ru.task.Task;

@Service
public class Task1ServiceImpl implements Task1Service {

    @Autowired
    TaskResults taskResults;

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);

    @Override
    public void prepareForTask(Task t) {

        logger.warn("Подготовка к выполнению задачи: "+t);
    }

    /**
     * Метод выполняет задачу возвращая результат
     * @return результат выполнения задачи
     */
    @Override
    public Object doTask(Task t) {

        logger.warn("<<< Старт выполнения задачи: "+t);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.warn(">>> Конец выполнения задачи: "+t);

        return "{Результат выполнения задачи type=1} "+t.getTaskId();
    }
}
