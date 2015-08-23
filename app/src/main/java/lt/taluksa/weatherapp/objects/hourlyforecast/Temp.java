package lt.taluksa.weatherapp.objects.hourlyforecast;

import com.google.gson.annotations.Expose;

public class Temp {

    @Expose
    private String english;
    @Expose
    private String metric;

    /**
     *
     * @return
     * The english
     */
    public String getEnglish() {
        return english;
    }

    /**
     *
     * @param english
     * The english
     */
    public void setEnglish(String english) {
        this.english = english;
    }

    /**
     *
     * @return
     * The metric
     */
    public String getMetric() {
        return metric;
    }

    /**
     *
     * @param metric
     * The metric
     */
    public void setMetric(String metric) {
        this.metric = metric;
    }

}