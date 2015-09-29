package broome.com.nastaavgang.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robin on 02/05/15.
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }
    @Provides
    public Context provideApplicationContext() {
        return this.application.getApplicationContext();
    }
/**  private final CustomApplication application;

    public ApplicationModule(CustomApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    //@Provides @Singleton
    //ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    //    return jobExecutor;
    //}
    */
}
