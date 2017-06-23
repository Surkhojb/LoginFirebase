package juanjo.example.loginfirebase.ui.fragments.series;

import java.util.List;

import juanjo.example.loginfirebase.data.model.Serie;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

public interface ListSeriesView {
    void showLoading(boolean state);
    void showError(String msg);
    void showSeries(List<Serie> series);
}
