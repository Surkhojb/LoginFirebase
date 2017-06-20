package juanjo.example.loginfirebase.di.components;

import dagger.Subcomponent;
import juanjo.example.loginfirebase.di.modules.FirebaseModule;
import juanjo.example.loginfirebase.ui.login.LoginModule;
import juanjo.example.loginfirebase.di.scopes.ActivityScope;
import juanjo.example.loginfirebase.ui.login.LoginActivity;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@ActivityScope
@Subcomponent(modules = {LoginModule.class,FirebaseModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
