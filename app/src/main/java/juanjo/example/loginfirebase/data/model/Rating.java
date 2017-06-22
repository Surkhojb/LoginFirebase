package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by juanjoberenguer on 21/6/17.
 */

public class Rating {

    @SerializedName("average")
    private Double average;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "average=" + average +
                '}';
    }
}
