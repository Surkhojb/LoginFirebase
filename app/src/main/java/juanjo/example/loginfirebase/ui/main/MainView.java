package juanjo.example.loginfirebase.ui.main;

import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
import juanjo.example.loginfirebase.data.model.Serie;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainView {
    String getQuery();

    void showLoading(boolean state);
    void showError(String msg);
    void showSerie(Serie serie);

    void launchDetailActivity();
}
