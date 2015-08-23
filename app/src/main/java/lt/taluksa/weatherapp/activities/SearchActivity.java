package lt.taluksa.weatherapp.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.Utils;
import lt.taluksa.weatherapp.adapters.SearchAdapter;
import lt.taluksa.weatherapp.objects.searchresults.SearchResults;
import lt.taluksa.weatherapp.rest.SearchApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SearchActivity extends Activity {

    @Bind(R.id.rl_progress) RelativeLayout rlProgress;
    @Bind(R.id.list) ListView list;
    @Bind(R.id.tv_no_cities) TextView tvNoCities;

    private SearchResults searchResults;
    private boolean stopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ButterKnife.bind(this);

        handleIntent(getIntent());
        listItemClick();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchRequest(query);
        }
    }

    private void searchRequest(String query) {
        if (!Utils.isNetworkEnabled(this, true)) {
            finish();
            return;
        }
        showLoading(true);

        SearchApi.getService().getSearchResults(query, new Callback<SearchResults>() {
            @Override
            public void success(SearchResults searchResults, Response response) {
                if (stopped) return;
                if (searchResults == null) {
                    showLoading(false);
                    tvNoCities.setVisibility(View.VISIBLE);
                    return;
                }

                SearchActivity.this.searchResults = searchResults;
                SearchAdapter adapter = new SearchAdapter(SearchActivity.this, searchResults);
                list.setAdapter(adapter);
                showLoading(false);
            }

            @Override
            public void failure(RetrofitError error) {
                if (stopped) return;

                Log.e("TAG", "cause: " + error.getCause());
                showLoading(false);
            }
        });
    }

    private void listItemClick() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCityData = searchResults.getResults().get(position).getL();

                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("selectedCityData", selectedCityData);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showLoading(boolean load) {
        if (load) {
            rlProgress.setVisibility(View.VISIBLE);
            list.setVisibility(View.GONE);
        } else {
            rlProgress.setVisibility(View.GONE);
            list.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStop() {
        stopped = true;
        super.onStop();
    }
}
