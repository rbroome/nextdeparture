package broome.com.nastaavgang.di;

import android.app.Application;



/**
 * Created by robin on 02/05/15.
 */
public class CustomApplication extends Application{

    private ApplicationComponent applicationComponent;
//    private ApiComponent apiComponent;


    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        //this.applicationComponent = DaggerApplicationComponent.builder()
          //      .applicationModule(new ApplicationModule(this))
            //    .build();
        //this.apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule(this)).build();
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
    public ApplicationComponent Component() {
        return this.applicationComponent;
    }

}
