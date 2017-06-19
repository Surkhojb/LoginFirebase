package juanjo.example.loginfirebase.ui.login.interactor;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.ui.login.presenter.LoginListener;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public interface LoginInteractor {
  Observable<String> loginUser(String user, String pass);

  void singUpUser(String user, String pass, LoginListener listener);
}
