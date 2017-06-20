package juanjo.example.loginfirebase.di.components;

import javax.inject.Singleton;

import dagger.Component;
import juanjo.example.loginfirebase.di.modules.LoginModule;
import juanjo.example.loginfirebase.di.modules.AppModule;
import juanjo.example.loginfirebase.di.modules.FirebaseModule;
import juanjo.example.loginfirebase.di.modules.ServiceModule;
import juanjo.example.loginfirebase.ui.main.MainActivity;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@Singleton
@Component(modules = {AppModule.class,ServiceModule.class})
public interface AppComponent {
    LoginComponent plus(LoginModule module);
    void inject(MainActivity activity);
}
