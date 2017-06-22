package juanjo.example.loginfirebase.ui.main.interactor;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;
import juanjo.example.loginfirebase.data.service.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public class MainInteractorImpl implements MainInteractor {
    @Inject
    RestApi mApi;
    List<SingleSerie> series = new ArrayList<SingleSerie>();

    @Inject
    public MainInteractorImpl(){}

    @Override
    public Observable<SingleSerie> getSerie(String query) {
        return mApi.getSerie(query);
    }

    @Override
    public Observable<List<Serie>> getSeries(String query) {
        return mApi.getSeries(query);
    }
}
