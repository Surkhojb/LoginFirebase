package juanjo.example.loginfirebase.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.Posts;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginApplication.get(this).getAppComponent().plus(new MainModule(this)).inject(this);
        presenter.loadPost();

    }
    @Override
    public String getQuery() {
        return null;
    }

    @Override
    public void showLoading(boolean state) {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPost(Posts post) {
        Toast.makeText(this,post.getTitle() + post.getBody(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchDetailActivity() {

    }
}
