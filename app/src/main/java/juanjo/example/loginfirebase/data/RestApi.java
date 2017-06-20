package juanjo.example.loginfirebase.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface RestApi {

    @GET("/posts")
    Observable<List<Posts>> getPosts();
}
