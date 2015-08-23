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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.adapters.WeeklyForecastAdapter;
import lt.taluksa.weatherapp.objects.weeklyforecast.ForecastDay;
import lt.taluksa.weatherapp.objects.weeklyforecast.WeeklyForecast;
import lt.taluksa.weatherapp.rest.WeatherApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class WeeklyForecastFragment extends Fragment {

    @Bind(R.id.rl_progress) RelativeLayout rlProgress;
    @Bind(R.id.list) ListView list;

    private String selectedCityData;

    public static WeeklyForecastFragment newInstance(String selectedCityData) {
        WeeklyForecastFragment weeklyForecastFragment = new WeeklyForecastFragment();

        Bundle args = new Bundle();
        args.putString("selectedCityData", selectedCityData);
        weeklyForecastFragment.setArguments(args);

        return weeklyForecastFragment;
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

        weeklyForecastRequest();
        return view;
    }

    private void weeklyForecastRequest() {
        showLoading(true);

        WeatherApi.getService().getWeeklyForecast(selectedCityData, new Callback<WeeklyForecast>() {
            @Override
            public void success(WeeklyForecast weeklyForecast, Response response) {
                if (!isAdded()) return;
                if (weeklyForecast == null) {
                    showLoading(false);
                    return;
                }

                getListOfWeek(weeklyForecast);
                WeeklyForecastAdapter adapter = new WeeklyForecastAdapter(getActivity(), weeklyForecast);
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

    //Deleting unnecessary week days. Leaving next 7 days
    private void getListOfWeek(WeeklyForecast weeklyForecast) {
        int listSize = weeklyForecast.getForecast().getSimpleForecast().getForecastday().size();
        List<ForecastDay> forecastDay = new ArrayList<>();

        for (int i = 7; i < listSize; i++) {
            forecastDay.add(weeklyForecast.getForecast().getSimpleForecast().getForecastday().get(i));
        }
        weeklyForecast.getForecast().getSimpleForecast().getForecastday().removeAll(forecastDay);
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
        weeklyForecastRequest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
