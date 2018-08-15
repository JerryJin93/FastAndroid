package com.jerryjin.fastandroid.utility.handler;

import com.jerryjin.fastandroid.utility.handler.runnable.Action;

import java.util.Queue;

public class ActionAsyncTask implements Action, Task {

    private final Action mAction;
    private Queue<Task> taskPool;
    private boolean mDone = false;

    public ActionAsyncTask(Action action) {
        this.mAction = action;
    }

    public ActionAsyncTask(Action action, boolean isDone) {
        this.mAction = action;
        this.mDone = isDone;
    }

    @Override
    public void activate() {
        if (!mDone) {
            synchronized (this) {
                if (!mDone) {
                    taskPool = null;
                    mAction.activate();
                    mDone = true;
                }
            }
        }
    }

    @Override
    public void setTaskPool(Queue<Task> taskPool) {
        this.taskPool = taskPool;
    }

    @Override
    public boolean isDone() {
        return mDone;
    }

    @Override
    public void cancel() {
        if (!mDone) {
            synchronized (this) {

            }
        }
    }
}
