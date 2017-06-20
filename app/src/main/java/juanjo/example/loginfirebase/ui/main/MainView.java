package juanjo.example.loginfirebase.ui.main;

import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainView {
    String getQuery();

    void showLoading(boolean state);
    void showError(String msg);

    void showPost(Post post);
    void showTotalPost(String total);

    void showComment(Comment comment);
    void showTotalComment(String total);

    void launchDetailActivity();
}
