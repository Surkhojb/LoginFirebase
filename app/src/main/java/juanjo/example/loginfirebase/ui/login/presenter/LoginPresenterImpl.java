package juanjo.example.loginfirebase.ui.login.presenter;

import javax.inject.Inject;

import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.ui.login.interactor.LoginInteractor;
import juanjo.example.loginfirebase.ui.login.view.LoginView;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public class LoginPresenterImpl implements LoginPresenter{
  private LoginView view;
  private LoginInteractor interactor;

  @Inject public LoginPresenterImpl(LoginView v, LoginInteractor i) {
    view = v;
    interactor = i;
  }

  @Override public void startLogin() {
    view.showCheckProgress();
    interactor.loginUser(view.getUserEmail(),view.getPassword()).subscribe(
            s -> view.showMessage(s),
            throwable -> view.showError(R.string.error_loging_user),
            () -> view.launchActivity());

  }

  @Override public void startSingUp() {
    view.showCheckProgress();
    interactor.singUpUser(view.getUserEmail(), view.getPassword()).subscribe(
            s -> view.showMessage(s),
            throwable -> view.showMessage(throwable.getLocalizedMessage()));
  }
}
