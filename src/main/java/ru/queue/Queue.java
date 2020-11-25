package ru.queue;

import org.springframework.stereotype.Component;
import ru.task.Task;

@Component
public interface Queue {

    public void connect();

    public Task getNextTask() throws IllegalStateException;

    public void disconnect();

    public boolean haveTasks();

}
