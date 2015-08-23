package lt.taluksa.weatherapp.activities;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.Utils;
import lt.taluksa.weatherapp.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.view_pager) ViewPager viewPager;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tv_search_country) TextView tvSearchCountry;
    @Bind(R.id.ll_main) LinearLayout llMain;

    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName cn = new ComponentName(this, SearchActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (!Utils.isNetworkEnabled(this, true)) return;

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        if (intent.getExtras() == null) {
            noDataForCountry();
            return;
        }

        String selectedCityData = intent.getStringExtra("selectedCityData");
        if (selectedCityData == null || selectedCityData.contains("global")) {
            noDataForCountry();
        } else {
            if (pagerAdapter == null) {
                pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, selectedCityData);
                viewPager.setAdapter(pagerAdapter);
                viewPager.setOffscreenPageLimit(2);
                tabLayout.setupWithViewPager(viewPager);
            } else {
                pagerAdapter.setSelectedCityData(selectedCityData);
            }

            llMain.setVisibility(View.VISIBLE);
            tvSearchCountry.setVisibility(View.GONE);
        }
    }

    private void noDataForCountry() {
        llMain.setVisibility(View.GONE);
        tvSearchCountry.setVisibility(View.VISIBLE);
        Toast.makeText(this, getResources().getString(R.string.no_weather_data), Toast.LENGTH_LONG).show();
    }
}
