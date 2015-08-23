package lt.taluksa.weatherapp.objects.weeklyforecast;

import com.google.gson.annotations.Expose;

public class WeeklyForecast {

    @Expose
    private Forecast forecast;

    /**
     *
     * @return
     * The forecast
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

}