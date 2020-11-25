package ru.task.impl;

import ru.task.Task;


public class TaskImp implements Task {

    private int taskId;
    private int taskType;
    private int payloadId;

    public TaskImp() {
    }

    public TaskImp(int taskId, int taskType, int payloadId) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.payloadId = payloadId;
    }

    @Override
    public int getTaskId() {
        return taskId;
    }

    @Override
    public int getTaskType() {
        return taskType;
    }

    @Override
    public int getPayloadId() {
        return payloadId;
    }

    @Override
    public String toString() {
        return "TaskImp{" +
                "taskId=" + taskId +
                ", taskType=" + taskType +
                ", payloadId=" + payloadId +
                '}';
    }
}
