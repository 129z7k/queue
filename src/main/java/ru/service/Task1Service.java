package ru.service;
import ru.task.Task;

public interface Task1Service {

    void prepareForTask(Task t);
    Object doTask(Task t);
}
