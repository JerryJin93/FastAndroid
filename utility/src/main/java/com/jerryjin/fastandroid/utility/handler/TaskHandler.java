package com.jerryjin.fastandroid.utility.handler;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public abstract class TaskHandler<T> extends Handler {

    WeakReference<T> tWeakReference;


}
