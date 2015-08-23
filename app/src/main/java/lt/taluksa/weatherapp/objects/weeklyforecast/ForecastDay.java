package lt.taluksa.weatherapp.objects.weeklyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    @Expose
    private Date date;
    @Expose
    private Integer period;
    @Expose
    private High high;
    @Expose
    private Low low;
    @Expose
    private String conditions;
    @Expose
    private String icon;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @Expose
    private String skyicon;
    @Expose
    private Integer pop;
    @Expose
    private Integer avehumidity;
    @Expose
    private Integer maxhumidity;
    @Expose
    private Integer minhumidity;

    /**
     *
     * @return
     * The date
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     *
     * @param period
     * The period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     *
     * @return
     * The high
     */
    public High getHigh() {
        return high;
    }

    /**
     *
     * @param high
     * The high
     */
    public void setHigh(High high) {
        this.high = high;
    }

    /**
     *
     * @return
     * The low
     */
    public Low getLow() {
        return low;
    }

    /**
     *
     * @param low
     * The low
     */
    public void setLow(Low low) {
        this.low = low;
    }

    /**
     *
     * @return
     * The conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     *
     * @param conditions
     * The conditions
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     *
     * @return
     * The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     * The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     *
     * @param iconUrl
     * The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     *
     * @return
     * The skyicon
     */
    public String getSkyicon() {
        return skyicon;
    }

    /**
     *
     * @param skyicon
     * The skyicon
     */
    public void setSkyicon(String skyicon) {
        this.skyicon = skyicon;
    }

    /**
     *
     * @return
     * The pop
     */
    public Integer getPop() {
        return pop;
    }

    /**
     *
     * @param pop
     * The pop
     */
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    /**
     *
     * @return
     * The avehumidity
     */
    public Integer getAvehumidity() {
        return avehumidity;
    }

    /**
     *
     * @param avehumidity
     * The avehumidity
     */
    public void setAvehumidity(Integer avehumidity) {
        this.avehumidity = avehumidity;
    }

    /**
     *
     * @return
     * The maxhumidity
     */
    public Integer getMaxhumidity() {
        return maxhumidity;
    }

    /**
     *
     * @param maxhumidity
     * The maxhumidity
     */
    public void setMaxhumidity(Integer maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    /**
     *
     * @return
     * The minhumidity
     */
    public Integer getMinhumidity() {
        return minhumidity;
    }

    /**
     *
     * @param minhumidity
     * The minhumidity
     */
    public void setMinhumidity(Integer minhumidity) {
        this.minhumidity = minhumidity;
    }

}