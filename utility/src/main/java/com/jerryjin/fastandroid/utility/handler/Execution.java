package com.jerryjin.fastandroid.utility.handler;

import android.os.Looper;

import com.jerryjin.fastandroid.utility.handler.runnable.Action;

public final class Execution {

    private static ExecutionHandler backgroundHandler;
    private static ExecutionHandler uiHandler;

    public static ExecutionHandler getBackgroundHandler() {
        if (backgroundHandler == null) {
            synchronized (Execution.class) {
                if (backgroundHandler == null) {
                    Thread thread = new Thread("BackgroundThread") {
                        @Override
                        public void run() {
                            Looper.prepare();
                            synchronized (Execution.class) {
                                backgroundHandler = new ExecutionHandler(Looper.myLooper(), 3000, true);
                                try {
                                    Execution.class.notifyAll();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            Looper.loop();
                        }
                    };
                    thread.setDaemon(true);
                    thread.setPriority(Thread.MAX_PRIORITY);
                    thread.start();
                    try {
                        Execution.class.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return backgroundHandler;
    }

    public static ExecutionHandler getUiHandler() {
        if (uiHandler == null) {
            synchronized (Execution.class) {
                if (uiHandler == null) {
                    uiHandler = new ExecutionHandler(Looper.getMainLooper(), 16, false);
                }
            }
        }
        return uiHandler;
    }

    public static Result updateUIAsync(Action action) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            action.activate();
            return new ActionAsyncTask(action, true);
        } else {
            ActionAsyncTask task = new ActionAsyncTask(action);
            getUiHandler().async(task);
            return task;
        }
    }

}
