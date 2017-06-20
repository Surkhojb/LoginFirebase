package juanjo.example.loginfirebase.ui.main;

import juanjo.example.loginfirebase.data.Posts;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainView {
    String getQuery();

    void showLoading(boolean state);
    void showError(String msg);
    void showPost(Posts post);

    void launchDetailActivity();
}
