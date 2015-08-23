package lt.taluksa.weatherapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.adapters.HourlyForecastAdapter;
import lt.taluksa.weatherapp.objects.hourlyforecast.HourlyForecast;
import lt.taluksa.weatherapp.rest.WeatherApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HourlyForecastFragment extends Fragment {

    @Bind(R.id.rl_progress) RelativeLayout rlProgress;
    @Bind(R.id.list) ListView list;

    private String selectedCityData;

    public static HourlyForecastFragment newInstance(String selectedCityData) {
        HourlyForecastFragment hourlyForecastFragment = new HourlyForecastFragment();

        Bundle args = new Bundle();
        args.putString("selectedCityData", selectedCityData);
        hourlyForecastFragment.setArguments(args);

        return hourlyForecastFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedCityData = getArguments().getString("selectedCityData");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview, container, false);
        ButterKnife.bind(this, view);

        hourlyForecastRequest();
        return view;
    }

    private void hourlyForecastRequest() {
        showLoading(true);

        WeatherApi.getService().getHourlyForecast(selectedCityData, new Callback<HourlyForecast>() {
            @Override
            public void success(HourlyForecast hourlyForecast, Response response) {
                if (!isAdded()) return;
                if (hourlyForecast == null) {
                    showLoading(false);
                    return;
                }

                HourlyForecastAdapter adapter = new HourlyForecastAdapter(getActivity(), hourlyForecast);
                list.setAdapter(adapter);
                showLoading(false);
            }

            @Override
            public void failure(RetrofitError error) {
                if (!isAdded()) return;
                Log.e("TAG", "cause: " + error.getCause());

                showLoading(false);
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

    public void refreshFragment(String selectedCityData) {
        this.selectedCityData = selectedCityData;
        hourlyForecastRequest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
