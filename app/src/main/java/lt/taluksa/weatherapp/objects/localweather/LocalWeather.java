package lt.taluksa.weatherapp.objects.localweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocalWeather {

    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;

    /**
     *
     * @return
     * The currentObservation
     */
    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    /**
     *
     * @param currentObservation
     * The current_observation
     */
    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

}