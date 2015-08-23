
package lt.taluksa.weatherapp.objects.weeklyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("simpleforecast")
    @Expose
    private SimpleForecast simpleForecast;

    /**
     * @return The simpleforecast
     */
    public SimpleForecast getSimpleForecast() {
        return simpleForecast;
    }

    /**
     * @param simpleForecast The simpleforecast
     */
    public void setSimpleForecast(SimpleForecast simpleForecast) {
        this.simpleForecast = simpleForecast;
    }

}