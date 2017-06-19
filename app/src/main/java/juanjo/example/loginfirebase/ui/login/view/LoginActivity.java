package juanjo.example.loginfirebase.ui.login.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.di.modules.LoginModule;
import juanjo.example.loginfirebase.ui.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView{

    EditText edEmail,edPass;
    Button mLogin,mSingUp;
    ProgressBar mProgress;

    @Inject
    LoginPresenter presenter;

    @Inject
    SharedPreferences mPreferences;
    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        injectDaggerComponent();
        loadView();
        mLogin.setOnClickListener(v -> login());
        mSingUp.setOnClickListener(v -> singUp());
    }

    void loadView(){
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPass = (EditText) findViewById(R.id.edPassword);
        mLogin = (Button) findViewById(R.id.btnLogin);
        mSingUp = (Button) findViewById(R.id.btnSingup);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        if(mPreferences.getBoolean("auto_login",false))
            mSingUp.setVisibility(View.GONE);
    }
    void injectDaggerComponent(){
        LoginApplication.get(this).getAppComponent().plus(new LoginModule(this)).inject(this);
    }

    @Override
    public String getUserEmail() {
        return edEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return edPass.getText().toString();
    }

    @Override
    public void showCheckProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCheckProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showInvalidUser(int resId) {
        hideCheckProgress();
        edEmail.setError(getString(resId));
        edPass.setError(getString(resId));
    }

    @Override
    public void showError(int resId) {
        hideCheckProgress();
        Toast.makeText(mContext,resId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String msg) {
        hideCheckProgress();
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        presenter.startLogin();
    }

    @Override
    public void singUp() {
        presenter.startSingUp();
    }
}
