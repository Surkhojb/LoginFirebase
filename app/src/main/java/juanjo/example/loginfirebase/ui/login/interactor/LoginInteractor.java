package juanjo.example.loginfirebase.ui.login.interactor;

import io.reactivex.Observable;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public interface LoginInteractor {
  Observable<String> loginUser(String user, String pass);

  Observable<String> singUpUser(String user, String pass);
}
