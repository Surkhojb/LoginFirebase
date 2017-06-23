package juanjo.example.loginfirebase.ui.fragments.series.interactor;

import java.util.List;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Serie;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

public interface ListSeriesInteractor {
    Observable<List<Serie>> getSeries(String query);
}
