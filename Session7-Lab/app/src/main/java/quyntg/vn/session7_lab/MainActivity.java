package quyntg.vn.session7_lab;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.iv11) ImageView iv11;
//    @BindView(R.id.iv12) ImageView iv12;
//    @BindView(R.id.iv13) ImageView iv13;
//    @BindView(R.id.iv14) ImageView iv14;
//    @BindView(R.id.iv2) ImageView iv2;
//    @BindView(R.id.iv3) ImageView iv3;
//    @BindView(R.id.iv4) ImageView iv4;

    @BindView(R.id.iv1) ImageView iv1;
    @BindView(R.id.iv21) ImageView iv21;
    @BindView(R.id.iv22) ImageView iv22;
    @BindView(R.id.iv23) ImageView iv23;
    @BindView(R.id.iv24) ImageView iv24;
    @BindView(R.id.iv31) ImageView iv31;
    @BindView(R.id.iv32) ImageView iv32;
    @BindView(R.id.iv33) ImageView iv33;
    @BindView(R.id.iv34) ImageView iv34;
    //@BindView(R.id.iv4) ImageView iv4;
    @BindView(R.id.ivcencast) ImageView ivcencast;
    @BindView(R.id.ivcen1) ImageView ivcen1;
    @BindView(R.id.ivcen2) ImageView ivcen2;
    @BindView(R.id.ivcen3) ImageView ivcen3;



    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        ButterKnife.bind(this);
        setupUI();
        getReferences();
        addListeners();
    }

    private void getReferences() {
        btn = (Button) findViewById(R.id.bt4);
    }

    private void addListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                BlankFragment blankFragment = new BlankFragment();
                blankFragment.show(fragmentManager,"");

            }
        });
    }

    private void setupUI() {
//        iv11.setImageResource(R.drawable.home_shape);
//        iv12.setImageResource(R.drawable.code_bar_shape);
//        iv13.setImageResource(R.drawable.alarm_shape);
//        iv14.setImageResource(R.drawable.person_shape);
//        iv2.setImageResource(R.drawable.men_fashion);
//        iv3.setImageResource(R.drawable.girl_fashion);
//        iv4.setImageResource(R.drawable.kids_fashion);

        iv1.setImageResource(R.drawable.girl_dressing);
        iv21.setImageResource(R.drawable.black);
        iv22.setImageResource(R.drawable.light_blue);
        iv23.setImageResource(R.drawable.dark_blue);
        iv24.setImageResource(R.drawable.dark_blue);
        iv31.setImageResource(R.drawable.ss);
        iv32.setImageResource(R.drawable.mm);
        iv33.setImageResource(R.drawable.ll);
        iv34.setImageResource(R.drawable.xll);

        //iv4.setImageResource(R.drawable.aaddtocart);
        ivcencast.setImageResource(R.drawable.aaddtocart);
        ivcen1.setImageResource(R.drawable.heart_shape);
        ivcen2.setImageResource(R.drawable.bookmark_shape);
        ivcen3.setImageResource(R.drawable.share_shape);


    }


}
