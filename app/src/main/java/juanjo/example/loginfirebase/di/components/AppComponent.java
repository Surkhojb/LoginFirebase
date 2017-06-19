package juanjo.example.loginfirebase.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import juanjo.example.loginfirebase.di.modules.LoginModule;
import juanjo.example.loginfirebase.ui.login.view.LoginActivity;
import juanjo.example.loginfirebase.di.modules.AppModule;
import juanjo.example.loginfirebase.di.modules.FirebaseModule;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@Singleton
@Component(modules = {AppModule.class,FirebaseModule.class})
public interface AppComponent {
    LoginComponent plus(LoginModule activity);
}
