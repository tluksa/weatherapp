package lt.taluksa.weatherapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.Utils;
import lt.taluksa.weatherapp.objects.localweather.CurrentObservation;
import lt.taluksa.weatherapp.objects.localweather.LocalWeather;
import lt.taluksa.weatherapp.rest.WeatherApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CurrentWeatherFragment extends Fragment {

    public static float COVER_IMAGE_HEIGHT = 0.35f; //How much screen height does the image take. from 0 to 1.

    @Bind(R.id.rl_cover) RelativeLayout rlCover;
    @Bind(R.id.iv_weather_condition) ImageView ivWeatherCondition;
    @Bind(R.id.tv_humidity_value) TextView tvHumidityValue;
    @Bind(R.id.tv_wind_value) TextView tvWindValue;
    @Bind(R.id.tv_pressure_value) TextView tvPressureValue;
    @Bind(R.id.tv_temperature) TextView tvTemperature;
    @Bind(R.id.rl_progress) RelativeLayout rlProgress;
    @Bind(R.id.sv_content) ScrollView svContent;
    @Bind(R.id.tv_updated_value) TextView tvUpdatedValue;
    @Bind(R.id.tv_feels_like_value) TextView tvFeelsLikeValue;
    @Bind(R.id.tv_weather) TextView tvWeather;

    private String selectedCityData;

    public static CurrentWeatherFragment newInstance(String selectedCityData) {
        CurrentWeatherFragment currentWeatherFragment = new CurrentWeatherFragment();

        Bundle args = new Bundle();
        args.putString("selectedCityData", selectedCityData);
        currentWeatherFragment.setArguments(args);

        return currentWeatherFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.current_weather_fragment, container, false);
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            selectedCityData = getArguments().getString("selectedCityData");
        }

        rlCover.getLayoutParams().height = (int) (Utils.getScreenHeight(getActivity()) * COVER_IMAGE_HEIGHT);
        rlCover.requestLayout();

        weatherRequest();
        return view;
    }

    private void weatherRequest() {
        showLoading(true);

        WeatherApi.getService().getCurrentWeather(selectedCityData, new Callback<LocalWeather>() {
            @Override
            public void success(LocalWeather localWeather, Response response) {
                if (!isAdded()) return;
                if (localWeather == null) {
                    showLoading(false);
                    return;
                }

                CurrentObservation obj = localWeather.getCurrentObservation();
                Picasso.with(getActivity()).load(obj.getIconUrl()).into(ivWeatherCondition);
                if (obj.getTempC() != null) tvTemperature.setText(obj.getTempC() + " \u2103");
                if (obj.getWeather() != null) tvWeather.setText(obj.getWeather());
                if (obj.getObservationEpoch() != null) tvUpdatedValue.setText(Utils.getHoursAndMinutes(obj.getObservationEpoch()));
                if (obj.getFeelslikeC() != null) tvFeelsLikeValue.setText(obj.getFeelslikeC() + " \u2103");
                if (obj.getRelativeHumidity() != null) tvHumidityValue.setText(obj.getRelativeHumidity());
                if (obj.getWindKph() != null) tvWindValue.setText(obj.getWindKph() + " km/h");
                if (obj.getPressureMb() != null) tvPressureValue.setText(obj.getPressureMb() + " hPa");
                showLoading(false);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG", "cause: " + error.getCause());
                Log.e("TAG", "url: " + error.getUrl());
                if (!isAdded()) return;

                showLoading(false);
            }
        });
    }

    private void showLoading(boolean load) {
        if (load) {
            rlProgress.setVisibility(View.VISIBLE);
            svContent.setVisibility(View.GONE);
        } else {
            rlProgress.setVisibility(View.GONE);
            svContent.setVisibility(View.VISIBLE);
        }
    }

    public void refreshFragment(String selectedCityData){
        this.selectedCityData = selectedCityData;
        weatherRequest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
