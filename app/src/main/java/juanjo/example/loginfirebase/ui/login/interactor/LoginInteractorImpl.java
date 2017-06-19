package juanjo.example.loginfirebase.ui.login.interactor;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

  @Inject FirebaseAuth mFirebase;
  @Inject SharedPreferences mPreferences;

  @Inject public LoginInteractorImpl() {
  }

  @Override public Observable<String> loginUser(String user, String pass) {
    if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
      return Observable.create(subscriber -> {
        subscriber.onNext("User or password can not be empty.");
      });
    } else {
      return Observable.create(subscriber -> {
        mFirebase.signInWithEmailAndPassword(user, pass).addOnCompleteListener(task -> {
          if (task.isSuccessful()) {
            subscriber.onNext("Welcome " + task.getResult().getUser().getEmail());
            if (!mPreferences.getBoolean("auto_login", false)) {
              mPreferences.edit().putBoolean("auto_login", true).apply();
            }
            subscriber.onComplete();
          } else {
            subscriber.onNext("Error loging your user credentials.");
          }
        });
      });
    }
  }

  @Override public Observable<String> singUpUser(String user, String pass) {
    if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
      return Observable.create(subscriber ->{
        subscriber.onNext("User or password can not be empty.");
      });
    } else {
      return Observable.create(subscriber -> {
        mFirebase.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(task -> {
          if(task.isSuccessful())
              subscriber.onNext("User created successfuly");
          else
            subscriber.onError(task.getException());
        });

      });

    }
  }
}
