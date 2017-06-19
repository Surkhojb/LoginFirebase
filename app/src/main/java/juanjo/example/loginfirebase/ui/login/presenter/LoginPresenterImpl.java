package juanjo.example.loginfirebase.ui.login.presenter;

import javax.inject.Inject;

import juanjo.example.loginfirebase.ui.login.interactor.LoginInteractor;
import juanjo.example.loginfirebase.ui.login.interactor.LoginListener;
import juanjo.example.loginfirebase.ui.login.view.LoginView;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginListener {
    private LoginView view;
    private LoginInteractor interactor;

    @Inject
    public LoginPresenterImpl(LoginView v, LoginInteractor i){
        view = v;
        interactor = i;
    }
    @Override
    public void startLogin() {
        view.showCheckProgress();
        interactor.loginUser(view.getUserEmail(),view.getPassword(),this);
    }

    @Override
    public void startSingUp() {
        view.showCheckProgress();
        interactor.singUpUser(view.getUserEmail(),view.getPassword(),this);

    }

    @Override
    public void onInvalidInputs(int resId) {
        view.showInvalidUser(resId);
    }

    @Override
    public void onSucces(String data) {
        view.showMessage(data);
    }

    @Override
    public void onFailure(int resId) {
        view.showError(resId);
    }
}
