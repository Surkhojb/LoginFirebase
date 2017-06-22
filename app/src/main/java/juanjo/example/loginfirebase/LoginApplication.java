package juanjo.example.loginfirebase;

import android.app.Application;
import android.content.Context;

import java.net.URL;

import juanjo.example.loginfirebase.di.components.AppComponent;
import juanjo.example.loginfirebase.di.components.DaggerAppComponent;
import juanjo.example.loginfirebase.di.modules.AppModule;
import juanjo.example.loginfirebase.di.modules.FirebaseModule;
import juanjo.example.loginfirebase.di.modules.ServiceModule;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public class LoginApplication extends Application {

    private LoginApplication instance;
    private AppComponent appComponent;
    private static final String URL_BASE = "http://api.tvmaze.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .serviceModule(new ServiceModule(URL_BASE   ))
                .build();
    }

    public AppComponent getAppComponent(){
        return this.appComponent;
    }

    public static LoginApplication get(Context context){
        return  (LoginApplication) context.getApplicationContext();
    }
}
