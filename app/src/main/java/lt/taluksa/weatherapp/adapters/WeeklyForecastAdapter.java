package lt.taluksa.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.objects.weeklyforecast.ForecastDay;
import lt.taluksa.weatherapp.objects.weeklyforecast.WeeklyForecast;

public class WeeklyForecastAdapter extends BaseAdapter {

    private WeeklyForecast weeklyForecast;
    private Context context;

    public WeeklyForecastAdapter(Context context, WeeklyForecast weeklyForecast) {
        this.weeklyForecast = weeklyForecast;
        this.context = context;
    }

    @Override
    public int getCount() {
        return weeklyForecast.getForecast().getSimpleForecast().getForecastday().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.forecast_row, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ForecastDay obj = weeklyForecast.getForecast().getSimpleForecast().getForecastday().get(position);
        Picasso.with(context).load(obj.getIconUrl()).into(holder.ivWeatherCondition);
        holder.tvTitle.setText(obj.getDate().getWeekday());
        holder.tvCelsius.setText(obj.getHigh().getCelsius() + " \u2103" +" / "+ obj.getLow().getCelsius() + " \u2103");
        holder.tvSubtitle.setText(obj.getConditions());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_weather_condition) ImageView ivWeatherCondition;
        @Bind(R.id.tv_title) TextView tvTitle;
        @Bind(R.id.tv_subtitle) TextView tvSubtitle;
        @Bind(R.id.tv_celsius) TextView tvCelsius;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
