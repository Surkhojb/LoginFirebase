package juanjo.example.loginfirebase.ui.login.interactor;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public interface LoginInteractor {
    void loginUser(String user,String pass,LoginListener listener);
    void singUpUser(String user,String pass,LoginListener listener);

}
