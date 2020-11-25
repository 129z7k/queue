package ru.queue.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.queue.Queue;
import ru.task.Task;
import ru.task.impl.TaskImp;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchedulerGetTest {

    @Autowired
    SchedulerGet schedulerGet;

    @MockBean
    private Queue  queue;

    @Test
    public void getTasks() {

        Task task1 = new TaskImp(10,10,10);
        Task task2 = new TaskImp(11,11,11);
        Mockito.when(queue.getNextTask()).thenReturn(task1,task2);
        Mockito.when(queue.haveTasks()).thenReturn(true,true,false);

        schedulerGet.GetTaskFromQueue();

        Mockito.verify(queue, times(2)).getNextTask();
        Mockito.verify(queue, atLeastOnce()).connect();
        Mockito.verify(queue, atLeastOnce()).disconnect();
        Mockito.verify(queue, atLeastOnce()).haveTasks();

    }






}