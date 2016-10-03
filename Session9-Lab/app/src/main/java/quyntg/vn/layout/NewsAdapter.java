package quyntg.vn.layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by giaqu on 10/3/2016.
 */
public class NewsAdapter extends ArrayAdapter<NewsItem>{

    public NewsAdapter(Context context, int resource, List<NewsItem> objects) {
        super(context, resource, objects);
    }

    @NonNull

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_news, parent, false);
        }
        //2
        new NewsViewHolder(convertView).setData(getItem(position));

        return convertView;
    }
}
