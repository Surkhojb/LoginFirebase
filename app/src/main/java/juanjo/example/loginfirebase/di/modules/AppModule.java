package juanjo.example.loginfirebase.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import juanjo.example.loginfirebase.LoginApplication;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@Module
public class AppModule {

    private Application application;
    private String PREF_NAME = "prefs_login_app";
    private SharedPreferences sharedPreferences;

    public AppModule(Application app){
        this.application = app;
        sharedPreferences = application.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences providePreferences(){
        return sharedPreferences;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application.getApplicationContext();
    }
}
