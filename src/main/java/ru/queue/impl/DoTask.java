package ru.queue.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.service.Task1Service;
import ru.service.Task2AsyncService;
import ru.service.TaskResults;
import ru.task.Task;

@Component
public class DoTask {

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);
    private final Task1Service task1Service;
    private final Task2AsyncService task2AsyncService;
    private final TaskResults taskResults;

    @Autowired
    public DoTask(Task1Service task1Service, Task2AsyncService task2AsyncService, TaskResults taskResults) {
        this.task1Service = task1Service;
        this.task2AsyncService = task2AsyncService;
        this.taskResults = taskResults;
    }


    /**
     * Метод в зависимости от типа задачи запускает выполнение с сохранением результата
     * @param t - задача,переданная на выполнение
     */
    public void doTaskFromQueue(Task t) {

        switch (t.getTaskType()) {
            case 1: {
                task1Service.prepareForTask(t);
                Object resultTask = task1Service.doTask(t);
                taskResults.saveResult(t,resultTask);
                break;
            }
            case 2: {
                int taskIdFromMapDoTasks = task2AsyncService.scheduleTask(t);
                Object resultTask = task2AsyncService.getStatus(t, taskIdFromMapDoTasks);
                taskResults.saveResult(t,resultTask);
                break;
            }

        }

    }
}

