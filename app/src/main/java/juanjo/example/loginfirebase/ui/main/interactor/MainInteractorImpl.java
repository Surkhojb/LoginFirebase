package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.Posts;
import juanjo.example.loginfirebase.data.RestApi;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public class MainInteractorImpl implements MainInteractor {
    @Inject
    RestApi mApi;

    @Inject
    public MainInteractorImpl(){}

    @Override
    public Observable<List<Posts>> getPosts() {
        return mApi.getPosts();
    }
}
