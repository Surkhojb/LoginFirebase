package juanjo.example.loginfirebase.ui.login.interactor;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.ui.login.presenter.LoginListener;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Inject
    FirebaseAuth mFirebase;
    @Inject
    SharedPreferences mPreferences;

    @Inject
    public LoginInteractorImpl(){}

    @Override
    public void loginUser(String user, String pass, final LoginListener listener) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            listener.onInvalidInputs(R.string.invalid_inputs);
        } else
            mFirebase.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        listener.onSucces("Welcome " + task.getResult().getUser().getEmail());
                        if(!mPreferences.getBoolean("auto_login",false))
                            mPreferences.edit().putBoolean("auto_login",true).commit();

                    }
                    else
                        listener.onFailure(R.string.error_loging_user);
                }
            });
    }

    @Override
    public void singUpUser(String user, String pass, final LoginListener listener) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            listener.onInvalidInputs(R.string.invalid_inputs);
        }else {
            mFirebase.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                        listener.onSucces("User created successfuly" + task.getResult().getUser().getUid());
                    else
                        listener.onFailure(R.string.error_creating_user);
                }
            });
        }
    }
}
