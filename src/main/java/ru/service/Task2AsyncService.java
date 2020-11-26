package ru.service;

import org.springframework.stereotype.Component;
import ru.task.Task;



public interface Task2AsyncService {

    int scheduleTask(Task t);
    Object getStatus(Task t, int subsystemTaskId);
}
