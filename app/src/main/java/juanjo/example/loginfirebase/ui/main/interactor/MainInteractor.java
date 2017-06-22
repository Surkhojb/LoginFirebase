package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;


import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainInteractor {
    Observable<SingleSerie> getSerie(String query);
    //Observable<List<SingleSerie>> getSeries(String query);
    Observable<List<Serie>> getSeries(String query);




}
