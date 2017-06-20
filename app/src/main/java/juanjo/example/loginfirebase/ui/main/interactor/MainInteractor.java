package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;


import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.Posts;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainInteractor {
    Observable<List<Posts>> getPosts();

}
