package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
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
    public Observable<List<Post>> getPosts() {
        return mApi.getPosts();
    }

    @Override
    public Observable<List<Comment>> getComments() {
        return mApi.getComments();
    }
}
