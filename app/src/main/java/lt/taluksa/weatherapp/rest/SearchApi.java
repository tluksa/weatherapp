package lt.taluksa.weatherapp.rest;

import lt.taluksa.weatherapp.constants.Url;
import lt.taluksa.weatherapp.objects.searchresults.SearchResults;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class SearchApi {

    public interface SearchService {

        @GET("/aq?lang=EN")
        void getSearchResults(@Query("query") String query, Callback<SearchResults> searchResults);
    }

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(Url.ENDPOINT_SEARCH)
            //.setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    private static final SearchService SEARCH_SERVICE = REST_ADAPTER.create(SearchService.class);

    public static SearchService getService() {
        return SEARCH_SERVICE;
    }

}
