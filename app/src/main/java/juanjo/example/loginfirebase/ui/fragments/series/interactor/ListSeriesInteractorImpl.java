package juanjo.example.loginfirebase.ui.fragments.series.interactor;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.service.RestApi;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

public class ListSeriesInteractorImpl implements ListSeriesInteractor {
    @Inject
    RestApi mApi;

    @Inject
    public ListSeriesInteractorImpl(){}

    @Override
    public Observable<List<Serie>> getSeries(String query) {
        Log.e("Fragment interactor: ","interactor query");
        return mApi.getSeries(query);
    }
}
