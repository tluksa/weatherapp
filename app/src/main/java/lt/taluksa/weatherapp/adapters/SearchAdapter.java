package lt.taluksa.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.taluksa.weatherapp.R;
import lt.taluksa.weatherapp.objects.searchresults.SearchResults;

public class SearchAdapter extends BaseAdapter {

    private SearchResults searcResults;
    private Context context;

    public SearchAdapter(Context context, SearchResults searcResults) {
        this.searcResults = searcResults;
        this.context = context;
    }

    @Override
    public int getCount() {
        return searcResults.getResults().size();
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
            convertView = inflater.inflate(R.layout.text_row, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(searcResults.getResults().get(position).getName());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.text_view) TextView textView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
