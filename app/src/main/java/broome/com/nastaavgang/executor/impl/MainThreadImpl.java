package broome.com.nastaavgang.executor.impl;


import broome.com.nastaavgang.executor.interfaces.MainThread;
import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by robin on 02/05/15.
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;


    @Inject
    public MainThreadImpl(){
        this.handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);

    }
}
