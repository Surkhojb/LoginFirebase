package juanjo.example.loginfirebase.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("previousepisode")
    @Expose
    private Previousepisode previousepisode;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Previousepisode getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(Previousepisode previousepisode) {
        this.previousepisode = previousepisode;
    }
}
