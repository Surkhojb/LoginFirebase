package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class Serie {
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("show")
    @Expose
    private Show show;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "score=" + score +
                ", show=" + show +
                '}';
    }
}
