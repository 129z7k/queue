package ru.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.QueueApplication;
import ru.queue.impl.SchedulerGet;
import ru.service.Task2AsyncService;
import ru.service.TaskResults;
import ru.task.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@Service
public class Task2AsyncServiceImpl implements Task2AsyncService {

    @Autowired
    TaskResults taskResults;

    private static Logger logger = LoggerFactory.getLogger(SchedulerGet.class);


    /**
     * Метод добавляет задачу идентификатор задачи в sub-хранилище и отправляет задачу на выполнение
     * @param t  - задача, которую необходимо выполнить
     * @return id записи в sub-хранилище выполняемых задач
     */
    @Override
    //Отправили задачу на выполнение и поместили в мапу со статусом выполнения null
    public int scheduleTask(Task t) {
        QueueApplication.mapDoTasks.put(t.getTaskId(),null);
        doProcess(t);
        logger.warn("Отправили задачу на выполнение: "+t);

        return t.getTaskId();
    }

    /**
     * Метод асинхронно выполняет задачу и возвращает результат в  sub-хранилище
     * @param t задача, которая выполняется
     */
    @Async
    public void doProcess(Task t) {

        logger.warn("<<< Старт выполнения задачи: "+t);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.warn(">>> Конец выполнения задачи: "+t);

        QueueApplication.mapDoTasks.put(t.getTaskId(),"{Результат выполнения задачи type=2}"+t.getTaskId());
    }


    /**
     * Метод проверяет sub-хранилище на наличие результата выполнения задачи
     * После появления результата его возвращает удаляя запись в sub-хранилище
     * @param subsystemTaskId
     * @return результат выполнения задачи
     */
    @Override
    public Object getStatus(Task t,int subsystemTaskId) {
        Object resultTask;

        while(true) {
            if (QueueApplication.mapDoTasks.get(subsystemTaskId)!=null){
                resultTask = QueueApplication.mapDoTasks.get(subsystemTaskId);
                break;
            }
        }

        QueueApplication.mapDoTasks.remove(subsystemTaskId);
        logger.warn("Получили результат выполнения задачи: "+t);
        return resultTask;
    }
}
