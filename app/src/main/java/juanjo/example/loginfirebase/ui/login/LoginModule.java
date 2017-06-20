package juanjo.example.loginfirebase.ui.login;

import dagger.Module;
import dagger.Provides;
import juanjo.example.loginfirebase.di.scopes.ActivityScope;
import juanjo.example.loginfirebase.ui.login.interactor.LoginInteractor;
import juanjo.example.loginfirebase.ui.login.interactor.LoginInteractorImpl;
import juanjo.example.loginfirebase.ui.login.presenter.LoginPresenter;
import juanjo.example.loginfirebase.ui.login.presenter.LoginPresenterImpl;
import juanjo.example.loginfirebase.ui.login.LoginView;

/**
 * Created by juanjoberenguer on 14/6/17.
 */


@Module
public class LoginModule {

    private LoginView view;

    public LoginModule(LoginView v) {
        view = v;
    }

    @Provides
    @ActivityScope
    public LoginView providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public LoginInteractor providesInteractor(LoginInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    public LoginPresenter providesPresenter(LoginPresenterImpl presenter) {

        return presenter;
    }
}
