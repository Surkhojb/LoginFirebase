package juanjo.example.loginfirebase.ui.main.interactor;

import java.util.List;


import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
import juanjo.example.loginfirebase.data.model.Serie;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface MainInteractor {
    Observable<Serie> getSerie(String query,String plot);
   // Observable<List<Comment>>getComments();


}
