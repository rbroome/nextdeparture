package broome.com.nastaavgang.executor.dagger;

import broome.com.nastaavgang.executor.impl.MainThreadImpl;
import broome.com.nastaavgang.executor.impl.ThreadExecutor;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.MainThread;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robin on 10/05/15.
 */
@Module
public class ExecutorModule {

    @Provides
    Executor provideExecutor(ThreadExecutor threadExecutor){
        return threadExecutor;
    }

    @Provides
    MainThread provideMainthread(MainThreadImpl mainThread){
        return mainThread;
    }

}
