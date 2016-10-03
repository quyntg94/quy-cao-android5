package quyntg.vn.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //@BindView(R.id.turn1) ViewCompund viewCompund;
//    @BindView(R.id.lv_news)
//    ListView lvNews;
//    @BindView(R.id.sb)
//    DiscreteSeekBar discreteSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turn51);
        ButterKnife.bind(this);
        //setupUI();
    }

    private void setupUI() {
        //lvNews.setAdapter(new NewsAdapter(this, R.layout.list_news, NewsItem.getNewsItems()));

//        discreteSeekBar.setProgress(20);
    }

}
