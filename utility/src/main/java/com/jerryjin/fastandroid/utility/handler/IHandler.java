package com.jerryjin.fastandroid.utility.handler;

public interface IHandler {

    int ASYNC = 0b01;
    int SYNC = 0b10;

    void async(Task task);

    void sync(Task task);

    void recycle();
}
