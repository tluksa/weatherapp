package lt.taluksa.weatherapp.objects.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HourlyForecast_ {

    @SerializedName("FCTTIME")
    @Expose
    private FctTime fctTime;
    @Expose
    private String condition;
    @Expose
    private Temp temp;
    @Expose
    private String icon;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @Expose
    private String fctcode;
    @Expose
    private String sky;
    @Expose
    private String wx;
    @Expose
    private String uvi;
    @Expose
    private String humidity;
    @Expose
    private String pop;

    /**
     * @return The temp
     */
    public Temp getTemp() {
        return temp;
    }

    /**
     * @param temp The temp
     */
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    /**
     * @return The FCTTIME
     */
    public FctTime getFctTime() {
        return fctTime;
    }

    /**
     * @param fctTime The FCTTIME
     */
    public void setFCTTIME(FctTime fctTime) {
        this.fctTime = fctTime;
    }

    /**
     * @return The condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition The condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * @param iconUrl The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * @return The fctcode
     */
    public String getFctcode() {
        return fctcode;
    }

    /**
     * @param fctcode The fctcode
     */
    public void setFctcode(String fctcode) {
        this.fctcode = fctcode;
    }

    /**
     * @return The sky
     */
    public String getSky() {
        return sky;
    }

    /**
     * @param sky The sky
     */
    public void setSky(String sky) {
        this.sky = sky;
    }

    /**
     * @return The wx
     */
    public String getWx() {
        return wx;
    }

    /**
     * @param wx The wx
     */
    public void setWx(String wx) {
        this.wx = wx;
    }

    /**
     * @return The uvi
     */
    public String getUvi() {
        return uvi;
    }

    /**
     * @param uvi The uvi
     */
    public void setUvi(String uvi) {
        this.uvi = uvi;
    }

    /**
     * @return The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * @param humidity The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * @return The pop
     */
    public String getPop() {
        return pop;
    }

    /**
     * @param pop The pop
     */
    public void setPop(String pop) {
        this.pop = pop;
    }


}