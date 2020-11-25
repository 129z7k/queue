package ru.queue.impl;

import org.springframework.stereotype.Component;
import ru.QueueApplication;
import ru.queue.Queue;
import ru.task.Task;

@Component
public class QueueImpl implements Queue {

    boolean connect = false;

    @Override
    public void connect() {
        connect = true;
    }

    /**
     * @return next task from queue or null if there are no tasks
     * @throws IllegalStateException
     */
    @Override
    public Task getNextTask() throws IllegalStateException {
        if (!connect) {
            throw new IllegalStateException();
        }

        try {
            return QueueApplication.tasksQueue.pollFirst();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void disconnect() {
        connect = false;
    }

    /**
     * @return the number of tasks in the queue
     */
    @Override
    public boolean haveTasks() {
        return QueueApplication.tasksQueue.size() > 0;
    }
}

