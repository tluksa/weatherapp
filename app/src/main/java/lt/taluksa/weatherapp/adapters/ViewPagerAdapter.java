package lt.taluksa.weatherapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lt.taluksa.weatherapp.fragments.WeeklyForecastFragment;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.fragments.CurrentWeatherFragment;
import lt.taluksa.weatherapp.fragments.HourlyForecastFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public static final int PAGES_COUNT = 3;
    public static final int CURRENT_LOCATION_WEATHER = 0;
    public static final int HOURLY_WEATHER_FORECAST = 1;
    public static final int WEEKLY_WEATHER_FORECAST = 2;

    private Context context;
    private String selectedCityData;

    public ViewPagerAdapter(FragmentManager fm, Context context, String selectedCountryData) {
        super(fm);
        this.context = context;
        this.selectedCityData = selectedCountryData;
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case CURRENT_LOCATION_WEATHER:
                title = context.getResources().getString(R.string.now);
                break;
            case HOURLY_WEATHER_FORECAST:
                title = context.getResources().getString(R.string.hourly);
                break;
            case WEEKLY_WEATHER_FORECAST:
                title = context.getResources().getString(R.string.forecast);
                break;
        }
        return title;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case CURRENT_LOCATION_WEATHER:
                fragment = CurrentWeatherFragment.newInstance(selectedCityData);
                break;
            case HOURLY_WEATHER_FORECAST:
                fragment = HourlyForecastFragment.newInstance(selectedCityData);
                break;
            case WEEKLY_WEATHER_FORECAST:
                fragment = WeeklyForecastFragment.newInstance(selectedCityData);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof CurrentWeatherFragment) {
            ((CurrentWeatherFragment) object).refreshFragment(selectedCityData);
        }else if(object instanceof HourlyForecastFragment){
            ((HourlyForecastFragment) object).refreshFragment(selectedCityData);
        }else if(object instanceof WeeklyForecastFragment){
            ((WeeklyForecastFragment) object).refreshFragment(selectedCityData);
        }
        return super.getItemPosition(object);
    }

    public void setSelectedCityData(String selectedCityData) {
        this.selectedCityData = selectedCityData;
        notifyDataSetChanged();
    }
}
