package ru.task.impl;

import ru.task.Task;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskImp taskImp = (TaskImp) o;
        return taskId == taskImp.taskId &&
                taskType == taskImp.taskType &&
                payloadId == taskImp.payloadId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskType, payloadId);
    }
}
