package lt.taluksa.weatherapp.objects.searchresults;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class SearchResults {

    @SerializedName("RESULTS")
    @Expose
    private List<Results> results = new ArrayList<Results>();

    /**
     *
     * @return
     * The RESULTS
     */
    public List<Results> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The RESULTS
     */
    public void setResults(List<Results> results) {
        this.results = results;
    }

}