package lt.taluksa.weatherapp.objects.searchresults;

import com.google.gson.annotations.Expose;

public class Results {

    @Expose
    private String name;
    @Expose
    private String type;
    @Expose
    private String c;
    @Expose
    private String zmw;
    @Expose
    private String tz;
    @Expose
    private String tzs;
    @Expose
    private String l;
    @Expose
    private String ll;
    @Expose
    private String lat;
    @Expose
    private String lon;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The c
     */
    public String getC() {
        return c;
    }

    /**
     *
     * @param c
     * The c
     */
    public void setC(String c) {
        this.c = c;
    }

    /**
     *
     * @return
     * The zmw
     */
    public String getZmw() {
        return zmw;
    }

    /**
     *
     * @param zmw
     * The zmw
     */
    public void setZmw(String zmw) {
        this.zmw = zmw;
    }

    /**
     *
     * @return
     * The tz
     */
    public String getTz() {
        return tz;
    }

    /**
     *
     * @param tz
     * The tz
     */
    public void setTz(String tz) {
        this.tz = tz;
    }

    /**
     *
     * @return
     * The tzs
     */
    public String getTzs() {
        return tzs;
    }

    /**
     *
     * @param tzs
     * The tzs
     */
    public void setTzs(String tzs) {
        this.tzs = tzs;
    }

    /**
     *
     * @return
     * The l
     */
    public String getL() {
        return l;
    }

    /**
     *
     * @param l
     * The l
     */
    public void setL(String l) {
        this.l = l;
    }

    /**
     *
     * @return
     * The ll
     */
    public String getLl() {
        return ll;
    }

    /**
     *
     * @param ll
     * The ll
     */
    public void setLl(String ll) {
        this.ll = ll;
    }

    /**
     *
     * @return
     * The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lon
     */
    public String getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

}