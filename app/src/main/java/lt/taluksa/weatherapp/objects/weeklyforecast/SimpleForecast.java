package lt.taluksa.weatherapp.objects.weeklyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SimpleForecast {

    @SerializedName("forecastday")
    @Expose
    private List<ForecastDay> forecastday = new ArrayList<ForecastDay>();

    /**
     *
     * @return
     * The forecastday
     */
    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    /**
     *
     * @param forecastday
     * The forecastday
     */
    public void setForecastday(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }

}