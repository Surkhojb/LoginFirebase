package juanjo.example.loginfirebase.ui.login.presenter;

/**
 * Created by juanjoberenguer on 19/6/17.
 */

public interface LoginListener {
    void onInvalidInputs(int resId);
    void onSucces(String data);
    void onFailure(int resId);
}
