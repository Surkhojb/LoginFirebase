package juanjo.example.loginfirebase.data.service;

import java.util.List;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Comment;
import juanjo.example.loginfirebase.data.model.Post;
import juanjo.example.loginfirebase.data.model.Serie;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface RestApi {

    /*
    @GET("/posts")
    Observable<List<Post>> getPosts();
    @GET("/comments")
    Observable<List<Comment>> getComments();*/
    @GET("?")
    Observable<Serie> getSerie(@Query("t") String title,@Query("plot") String plot);


}
