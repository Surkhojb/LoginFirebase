package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class Schedule {
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("days")
    @Expose
    private List<String> days = null;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "time='" + time + '\'' +
                ", days=" + days +
                '}';
    }
}
