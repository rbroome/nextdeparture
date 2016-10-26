package broome.com.nastaavgang.di;

import android.app.Application;



/**
 * Base application containing the applicationComponent.
 * Also builds the dependency graph
 * Created by robin on 02/05/15.
 */
public class CustomApplication extends Application{

    private ApplicationComponent applicationComponent;


    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
    public ApplicationComponent Component() {
        return this.applicationComponent;
    }

}
