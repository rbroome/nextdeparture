package broome.com.nastaavgang.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Module containing the application context.
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

}
