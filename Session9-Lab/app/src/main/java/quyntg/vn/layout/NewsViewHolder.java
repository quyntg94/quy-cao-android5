package quyntg.vn.layout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by giaqu on 10/3/2016.
 */
public class NewsViewHolder {

    @BindView(R.id.tv_title) public TextView tvTitle;
    @BindView(R.id.tv_time) public TextView tvTime;
    @BindView(R.id.iv_image) public ImageView ivImage;

    public NewsViewHolder(View rootView){
        ButterKnife.bind(this, rootView);
    }

    public void setData(NewsItem newsItem){
        tvTitle.setText(newsItem.getTitle());
        ivImage.setImageResource(newsItem.getImage());
        tvTime.setText(newsItem.getTime());

    }
}
