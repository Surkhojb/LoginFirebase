package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.service.RestApi;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public class MainInteractorImpl implements MainInteractor {
    @Inject
    RestApi mApi;

    @Inject
    public MainInteractorImpl(){}

    @Override
    public Observable<Serie> getSerie(String query, String plot) {
        return mApi.getSerie(query,plot);
    }
}
