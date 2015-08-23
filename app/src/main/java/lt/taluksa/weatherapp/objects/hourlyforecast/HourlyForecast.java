package lt.taluksa.weatherapp.objects.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HourlyForecast {

    @SerializedName("hourly_forecast")
    @Expose
    private List<HourlyForecast_> hourlyForecast = new ArrayList<>();

    /**
     *
     * @return
     * The hourlyForecast
     */
    public List<HourlyForecast_> getHourlyForecast() {
        return hourlyForecast;
    }

    /**
     *
     * @param hourlyForecast
     * The hourly_forecast
     */
    public void setHourlyForecast(List<HourlyForecast_> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

}