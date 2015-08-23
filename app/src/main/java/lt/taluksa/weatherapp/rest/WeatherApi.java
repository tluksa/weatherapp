package lt.taluksa.weatherapp.rest;

import lt.taluksa.weatherapp.constants.Url;
import lt.taluksa.weatherapp.objects.hourlyforecast.HourlyForecast;
import lt.taluksa.weatherapp.objects.localweather.LocalWeather;
import lt.taluksa.weatherapp.objects.weeklyforecast.WeeklyForecast;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

public class WeatherApi {

    /**
     * Weather Underground API
     * 500 available requests in a day
     * 10  available requests in a minute
     */

    public interface WeatherService {

        @GET(Url.CURRENT_WEATHER + "{countryData}.json")
        void getCurrentWeather(@Path(value = "countryData", encode = false) String countryData, Callback<LocalWeather> localWeather);

        @GET(Url.HOURLY_FORECAST + "{countryData}.json")
        void getHourlyForecast(@Path(value = "countryData", encode = false) String countryData, Callback<HourlyForecast> hourlyForecast);

        @GET(Url.WEEKLY_FORECAST + "{countryData}.json")
        void getWeeklyForecast(@Path(value = "countryData", encode = false) String countryData, Callback<WeeklyForecast> weeklyForecast);
    }

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(Url.ENDPOINT_WEATHER)
            //.setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    private static final WeatherService WEATHER_SERVICE = REST_ADAPTER.create(WeatherService.class);

    public static WeatherService getService() {
        return WEATHER_SERVICE;
    }

}
