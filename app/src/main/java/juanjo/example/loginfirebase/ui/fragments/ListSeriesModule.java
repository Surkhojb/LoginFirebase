package juanjo.example.loginfirebase.ui.fragments;

import dagger.Module;
import dagger.Provides;
import juanjo.example.loginfirebase.di.scopes.PerFragment;
import juanjo.example.loginfirebase.ui.fragments.series.interactor.ListSeriesInteractor;
import juanjo.example.loginfirebase.ui.fragments.series.interactor.ListSeriesInteractorImpl;
import juanjo.example.loginfirebase.ui.fragments.series.presenter.ListSeriesPresenter;
import juanjo.example.loginfirebase.ui.fragments.series.presenter.ListSeriesPresenterImpl;
import juanjo.example.loginfirebase.ui.fragments.series.ListSeriesView;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

@Module
public class ListSeriesModule {
    ListSeriesView view;

    public ListSeriesModule(ListSeriesView v){
        view = v;
    }

    @PerFragment
    @Provides
    ListSeriesView providesView(){
        return view;
    }

    @PerFragment
    @Provides
    ListSeriesPresenter providesPresenter(ListSeriesPresenterImpl presenter){
        return presenter;
    }

    @PerFragment
    @Provides
    ListSeriesInteractor providesInteractor(ListSeriesInteractorImpl interactor){
        return interactor;
    }


}
