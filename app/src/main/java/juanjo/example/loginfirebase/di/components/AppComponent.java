package juanjo.example.loginfirebase.di.components;

import javax.inject.Singleton;

import dagger.Component;
import juanjo.example.loginfirebase.ui.fragments.ListSeriesModule;
import juanjo.example.loginfirebase.ui.login.LoginModule;
import juanjo.example.loginfirebase.di.modules.AppModule;
import juanjo.example.loginfirebase.ui.main.MainModule;
import juanjo.example.loginfirebase.di.modules.ServiceModule;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@Singleton
@Component(modules = {AppModule.class,ServiceModule.class})
public interface AppComponent {
    LoginComponent plus(LoginModule module);
    MainComponent plus(MainModule module);
    ListSeriesComponent plusFragment(ListSeriesModule module);
}
