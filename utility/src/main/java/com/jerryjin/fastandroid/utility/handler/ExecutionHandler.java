package com.jerryjin.fastandroid.utility.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jerryjin.fastandroid.utility.handler.runnable.Action;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

public final class ExecutionHandler extends Handler implements IHandler {

    private static int maxHandleTime = 16;
    private Allocator asyncAllocator;
    private Allocator syncAllocator;

    public ExecutionHandler(Looper looper, int maxHandleTime, boolean async) {
        super(looper);

        ExecutionHandler.maxHandleTime = maxHandleTime;
        asyncAllocator = new Allocator(new LinkedList<Task>(), new Poster() {
            @Override
            public void sendMessage() {
                ExecutionHandler.this.sendMessage(ASYNC);
            }
        });

        if (async) {
            syncAllocator = asyncAllocator;
        } else {
            syncAllocator = new Allocator(new LinkedList<Task>(), new Poster() {
                @Override
                public void sendMessage() {
                    ExecutionHandler.this.sendMessage(SYNC);
                }
            });
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ASYNC:
                asyncAllocator.allocate();
                break;
            case SYNC:
                syncAllocator.allocate();
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }


    private void sendMessage(int what) {
        if (!sendMessage(obtainMessage(what))) {
            throw new RuntimeException("Fail to send message to handler.");
        }
    }

    @Override
    public void async(@NonNull Task task) {
        asyncAllocator.offer(task);
    }

    @Override
    public void sync(@NonNull Task task) {
        syncAllocator.offer(task);
    }

    @Override
    public void recycle() {
        removeCallbacksAndMessages(null);
        asyncAllocator.recycle();
        syncAllocator.recycle();
    }

    private static class Allocator {

        private final Queue<Task> taskPool;
        @Nullable
        private Poster iPoster;
        private boolean isActive;

        Allocator(Queue<Task> taskPool, Poster iPoster) {
            this.taskPool = taskPool;
            this.iPoster = iPoster;
        }

        void offer(@NonNull Task task) {
            synchronized (taskPool) {
                taskPool.offer(task);
                task.setTaskPool(taskPool);
                if (!isActive) {
                    isActive = true;
                    Poster poster = iPoster;
                    if (poster != null) {
                        poster.sendMessage();
                    }
                }
            }
        }

        void allocate() {
            boolean reschedule = false;
            long startTime = SystemClock.uptimeMillis();
            while (true) {
                Action action = poll();
                if (action == null) {
                    synchronized (taskPool) {
                        action = poll();
                        if (action == null) {
                            isActive = false;
                            break;
                        }
                    }
                }
                action.activate();
                long usedTime = SystemClock.uptimeMillis() - startTime;
                if (usedTime >= maxHandleTime) {
                    Poster poster = iPoster;
                    if (poster != null) {
                        poster.sendMessage();
                    }
                    reschedule = true;
                    break;
                }
            }
            isActive = reschedule;
        }

        void recycle() {
            taskPool.clear();
            iPoster = null;
        }


        private Action poll() {
            synchronized (taskPool) {
                try {
                    return taskPool.poll();
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
