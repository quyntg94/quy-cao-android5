package quyntg.vn.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv1) ImageView iv1;
    @BindView(R.id.iv21) ImageView iv21;
    @BindView(R.id.iv22) ImageView iv22;
    @BindView(R.id.iv23) ImageView iv23;
    @BindView(R.id.iv24) ImageView iv24;
    @BindView(R.id.iv25) ImageView iv25;
    @BindView(R.id.iv26) ImageView iv26;
    @BindView(R.id.iv27) ImageView iv27;
    @BindView(R.id.iv28) ImageView iv28;
    @BindView(R.id.iv29) ImageView iv29;
    @BindView(R.id.iv31) ImageView iv31;
    @BindView(R.id.iv32) ImageView iv32;
    @BindView(R.id.iv33) ImageView iv33;
    @BindView(R.id.iv34) ImageView iv34;
    @BindView(R.id.iv35) ImageView iv35;
    @BindView(R.id.iv36) ImageView iv36;
    @BindView(R.id.iv37) ImageView iv37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
//        iv1.setImageResource(R.drawable.ovalavatar);
//        iv21.setImageResource(R.drawable.bitmap4);
//        iv22.setImageResource(R.drawable.bitmap3);
//        iv23.setImageResource(R.drawable.bitmap7);
//        iv24.setImageResource(R.drawable.bitmap2);
//        iv25.setImageResource(R.drawable.bitmap1);
//        iv26.setImageResource(R.drawable.bitmap1);
//        iv27.setImageResource(R.drawable.bitmap8);
//        iv28.setImageResource(R.drawable.bitmap6);
//        iv29.setImageResource(R.drawable.playicongroup);
//        iv31.setImageResource(R.drawable.bitmap12);
//        iv32.setImageResource(R.drawable.bitmap11);
//        iv33.setImageResource(R.drawable.albums);
//        iv34.setImageResource(R.drawable.path);
//        iv35.setImageResource(R.drawable.music_note);
//        iv36.setImageResource(R.drawable.radio);
//        iv37.setImageResource(R.drawable.search);
    }
}
