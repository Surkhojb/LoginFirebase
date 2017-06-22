package juanjo.example.loginfirebase.data.service;

import java.util.List;

import io.reactivex.Observable;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public interface RestApi {

    @GET("singlesearch/shows?")
    Observable<SingleSerie> getSerie(@Query("q") String query);
    @GET("search/shows?")
    Observable<List<Serie>> getSeries(@Query("q") String query);


}
