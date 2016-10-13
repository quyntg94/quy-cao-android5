package quyntg.vn.session12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import quyntg.vn.session12.jsonmodels.FlickrItem;

/**
 * Created by giaqu on 10/13/2016.
 */
public class FlickrAdapter extends ArrayAdapter<FlickrItem> {

    public FlickrAdapter(Context context, int resource, List<FlickrItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.listview, parent, false);

        FlickrItem item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvDateTaken = (TextView) convertView.findViewById(R.id.tv_dateTaken);
        TextView tvLink = (TextView) convertView.findViewById(R.id.tv_link);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.iv_image);

        tvTitle.setText(item.getTitle());
        tvDateTaken.setText(item.getDateTaken());
        tvLink.setText(item.getImageLink());

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext()).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(item.getImageLink(), ivImage);

        return convertView;
    }
}
