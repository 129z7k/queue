package ru;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.queue.impl.SchedulerGet;
import ru.task.Task;
import ru.task.impl.TaskImp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
public class QueueApplication {


    /**
     * Очередь задач
     */
    static public ArrayDeque<Task> tasksQueue = new ArrayDeque<Task>();

    static {
        tasksQueue.add(new TaskImp(1, 1, 1));
        tasksQueue.add(new TaskImp(2, 2, 2));
        tasksQueue.add(new TaskImp(3, 1, 3));
        tasksQueue.add(new TaskImp(4, 2, 4));
    }

    /**
     * sub-хранилище выполняемых задач
     */
    static public Map<Integer, Object> mapDoTasks = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(QueueApplication.class, args);
    }

}
