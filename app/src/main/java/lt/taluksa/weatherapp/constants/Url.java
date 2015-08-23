package lt.taluksa.weatherapp.constants;

public abstract class Url {

    public static final String ENDPOINT_WEATHER = "http://api.wunderground.com/api/e4588ca9116e7891";
    public static final String ENDPOINT_SEARCH = "http://autocomplete.wunderground.com";

    public static final String CURRENT_WEATHER = "/conditions";
    public static final String HOURLY_FORECAST = "/hourly";
    public static final String WEEKLY_FORECAST = "/forecast10day";
}
