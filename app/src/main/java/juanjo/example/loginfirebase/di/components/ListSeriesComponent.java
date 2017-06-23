package juanjo.example.loginfirebase.di.components;

import dagger.Subcomponent;
import juanjo.example.loginfirebase.di.scopes.PerFragment;
import juanjo.example.loginfirebase.ui.fragments.series.ListSeries;
import juanjo.example.loginfirebase.ui.fragments.ListSeriesModule;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

@PerFragment
@Subcomponent(modules = ListSeriesModule.class)
public interface ListSeriesComponent {
    void inject(ListSeries fragment);
}
