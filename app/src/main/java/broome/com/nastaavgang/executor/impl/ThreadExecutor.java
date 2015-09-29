package broome.com.nastaavgang.executor.impl;

import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by robin on 02/05/15.
 */
public class ThreadExecutor implements Executor {

    private String TAG = this.getClass().getName();
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public ThreadExecutor(){
        int corePoolSize = CORE_POOL_SIZE;
        int maxPoolSize = MAX_POOL_SIZE;
        int keepAliveTime = KEEP_ALIVE_TIME;
        TimeUnit timeUnit = TIME_UNIT;
        BlockingQueue<Runnable> workQueue = WORK_QUEUE;
        threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

    }



    @Override
    public void run(final Interactor interactor) {
        if(interactor != null){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG,"running interactor: "+interactor.getClass().getSimpleName());
                    interactor.run();
                }
            });
        }
        else{
            Log.e(TAG,"Interactor can't be null");
        }

    }
}
