package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class Previousepisode {

    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Previousepisode{" +
                "href='" + href + '\'' +
                '}';
    }
}
