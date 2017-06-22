package juanjo.example.loginfirebase.ui.main;

import java.util.List;

import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainView {

    void showLoading(boolean state);
    void showError(String msg);
    void showSerie(List<Serie> series);

    void launchDetailActivity();
}
