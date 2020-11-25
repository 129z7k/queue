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
import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
public class QueueApplication  {


    /**
     *  ArrayDeque based queue filled with demo data
     */
    static public ArrayDeque<Task> tasksQueue = new ArrayDeque<Task>();
    static {
        tasksQueue.add(new TaskImp(1,1,1));
        tasksQueue.add(new TaskImp(2,1,2));
        tasksQueue.add(new TaskImp(3,2,3));
        tasksQueue.add(new TaskImp(4,2,4));
        tasksQueue.add(new TaskImp(5,1,5));;
        tasksQueue.add(new TaskImp(6,3,6));
        tasksQueue.add(new TaskImp(7,3,7));
    }

    public static void main(String[] args) {
        SpringApplication.run(QueueApplication.class, args);
    }





}
