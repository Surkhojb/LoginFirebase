package juanjo.example.loginfirebase.di.components;

import dagger.Subcomponent;
import juanjo.example.loginfirebase.ui.main.MainModule;
import juanjo.example.loginfirebase.di.scopes.ActivityScope;
import juanjo.example.loginfirebase.ui.main.MainActivity;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
