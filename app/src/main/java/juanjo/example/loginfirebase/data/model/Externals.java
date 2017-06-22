package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class Externals {

    @SerializedName("tvrage")
    @Expose
    private Integer tvrage;
    @SerializedName("thetvdb")
    @Expose
    private Integer thetvdb;
    @SerializedName("imdb")
    @Expose
    private String imdb;

    public Integer getTvrage() {
        return tvrage;
    }

    public void setTvrage(Integer tvrage) {
        this.tvrage = tvrage;
    }

    public Integer getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(Integer thetvdb) {
        this.thetvdb = thetvdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Externals{" +
                "tvrage=" + tvrage +
                ", thetvdb=" + thetvdb +
                ", imdb='" + imdb + '\'' +
                '}';
    }
}
