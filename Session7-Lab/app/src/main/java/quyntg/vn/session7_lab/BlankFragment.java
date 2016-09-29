package quyntg.vn.session7_lab;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends DialogFragment {

    @BindView(R.id.fiv21) ImageView fiv21;
    @BindView(R.id.fiv22) ImageView fiv22;
    @BindView(R.id.fiv23) ImageView fiv23;
    @BindView(R.id.fiv24) ImageView fiv24;
    @BindView(R.id.fiv31) ImageView fiv31;
    @BindView(R.id.fiv32) ImageView fiv32;
    @BindView(R.id.fiv33) ImageView fiv33;
    @BindView(R.id.fiv34) ImageView fiv34;
    @BindView(R.id.fiv4) ImageView fiv4;

    public BlankFragment() {
        // Required empty public constructor
//        setupUI();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        ButterKnife.bind(this, view);

        BindData();

        return view;
    }

    private void BindData() {

        fiv21.setImageResource(R.drawable.black);
        fiv22.setImageResource(R.drawable.light_blue);
        fiv23.setImageResource(R.drawable.dark_blue);
        fiv24.setImageResource(R.drawable.dark_blue);
        fiv31.setImageResource(R.drawable.ss);
        fiv32.setImageResource(R.drawable.mm);
        fiv33.setImageResource(R.drawable.ll);
        fiv34.setImageResource(R.drawable.xll);
        fiv4.setImageResource(R.drawable.aaddtocart);
    }

    private void setupUI() {

    }

}
