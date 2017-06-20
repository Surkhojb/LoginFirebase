package juanjo.example.loginfirebase.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    TextView mPost;
    TextView mTotalPost;
    TextView mComment;
    TextView mTotalComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUI();
        LoginApplication.get(this).getAppComponent().plus(new MainModule(this)).inject(this);

        presenter.loadPost();
        presenter.loadComment();

    }
    void loadUI(){
        mPost = (TextView) findViewById(R.id.tvPost);
        mTotalPost = (TextView) findViewById(R.id.tvTotalPost);
        mComment = (TextView) findViewById(R.id.tvComment);
        mTotalComment = (TextView) findViewById(R.id.tvTotalComment);
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
    public void showPost(Post post) {
        mPost.setText(post.getTitle() + "\n" + post.getBody());
    }

    @Override
    public void showTotalPost(String total) {
        mTotalPost.setText(mTotalPost.getText() + total);
    }

    @Override
    public void showComment(Comment comment) {
        mComment.setText(comment.getName() + "\n" + comment.getBody());
    }

    @Override
    public void showTotalComment(String total) {
        mTotalComment.setText(mTotalComment.getText() + total);
    }

    @Override
    public void launchDetailActivity() {

    }
}
