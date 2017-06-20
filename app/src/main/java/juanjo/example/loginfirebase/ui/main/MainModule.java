package juanjo.example.loginfirebase.ui.main;

import dagger.Module;
import dagger.Provides;
import juanjo.example.loginfirebase.di.scopes.ActivityScope;
import juanjo.example.loginfirebase.ui.main.interactor.MainInteractor;
import juanjo.example.loginfirebase.ui.main.interactor.MainInteractorImpl;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenter;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenterImpl;
import juanjo.example.loginfirebase.ui.main.MainView;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

@Module
public class MainModule {

    MainView view;

    public MainModule(MainView v){
        view = v;
    }

    @ActivityScope
    @Provides
    MainView providesView(){
        return view;
    }

    @ActivityScope
    @Provides
    MainPresenter providesPresenter(MainPresenterImpl presenter){
        return presenter;
    }

    @ActivityScope
    @Provides
    MainInteractor providesInteractor(MainInteractorImpl interactor){
        return  interactor;
    }
}
