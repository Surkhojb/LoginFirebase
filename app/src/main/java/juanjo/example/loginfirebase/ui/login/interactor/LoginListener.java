package juanjo.example.loginfirebase.ui.login.interactor;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public interface LoginListener {
    void onInvalidInputs(int resId);
    void onSucces(String data);
    void onFailure(int resId);
}
