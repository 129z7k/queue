package ru.queue.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.queue.Queue;
import ru.task.Task;
import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SchedulerGet {

    private final Queue queue;
    private final DoTask doTask;
    private final String numPool;
    private ExecutorService executorService;


    @Autowired
    public SchedulerGet(Queue queue, DoTask doTask, @Value("${numPool}") String numPool) {
        this.queue = queue;
        this.doTask = doTask;
        this.numPool = numPool;
    }

    @PostConstruct
    public void init() {
        executorService = Executors.newFixedThreadPool(Integer.parseInt(numPool));
    }

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);


    /**
     * Метод получает очередную задачу из очереди и отправляет на исполнение
     *
     * @throws IllegalStateException
     */
    @Scheduled(fixedRateString = "${scheduledtimeout}")
    public boolean GetTaskFromQueue() {

        queue.connect();
        try {
            while (queue.haveTasks()) {
                Task t = queue.getNextTask();

                logger.warn("Получили задачу из очереди: "+t);

                executorService.execute(new Runnable() {
                    public void run() {
                        doTask.doTaskFromQueue(t);
                    }
                });

            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
        queue.disconnect();
        return true;
    }
}
