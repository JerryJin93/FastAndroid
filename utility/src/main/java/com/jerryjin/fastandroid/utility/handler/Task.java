package com.jerryjin.fastandroid.utility.handler;

import com.jerryjin.fastandroid.utility.handler.runnable.Action;

import java.util.Queue;

public interface Task extends Action, Result {
    void setTaskPool(Queue<Task> taskPool);
}
