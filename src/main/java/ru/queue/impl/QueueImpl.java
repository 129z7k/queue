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
     * Метод возвращает очередную задачу из очереди, или null, если задач нет
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
     * Метод возвращает количество задач в очереди
     */
    @Override
    public boolean haveTasks() {
        return QueueApplication.tasksQueue.size() > 0;
    }
}

