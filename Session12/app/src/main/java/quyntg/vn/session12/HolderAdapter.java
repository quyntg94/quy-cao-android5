package quyntg.vn.session12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import quyntg.vn.session12.jsonmodels.HolderItem;

/**
 * Created by giaqu on 10/14/2016.
 */
public class HolderAdapter extends ArrayAdapter<HolderItem> {

    public HolderAdapter(Context context, int resource, HolderItem[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.listview_, parent, false);

        HolderItem item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        TextView tvUserId = (TextView) convertView.findViewById(R.id.tvUserId);


        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        tvUserId.setText(item.getUserId());

        return convertView;
    }
}
