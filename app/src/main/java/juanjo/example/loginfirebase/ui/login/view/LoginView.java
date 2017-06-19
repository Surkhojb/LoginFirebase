package juanjo.example.loginfirebase.ui.login.view;

import juanjo.example.loginfirebase.ui.login.interactor.LoginListener;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public interface LoginView{
    String getUserEmail();
    String getPassword();

    void showCheckProgress();
    void hideCheckProgress();

    void showInvalidUser(int resId);
    void showError(int resId);
    void showMessage(String msg);

    void login();
    void singUp();

}
