package lt.taluksa.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;


public class Utils {

    /**
     * Generate HH:mm from unix time stamp
     *
     * @param unixStamp pass unix timestamp
     * @return HOURS:MINUTES(HH:mm)
     */
    public static String getHoursAndMinutes(String unixStamp) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(unixStamp) * 1000);
        return DateFormat.format("HH:mm", calendar).toString();
    }


    public static int getScreenHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public static boolean isNetworkEnabled(Context context, boolean showToast) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        } else {
            if (showToast) Toast.makeText(context, context.getString(R.string.no_connection), Toast.LENGTH_LONG).show();
            return false;
        }
    }

}
