package quyntg.vn.foodlist;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDetailFragment extends Fragment {

    private Food food;

    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvDescription;

    public FoodDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);
        getReferences(view);
        setupUI();
        addListeners();
        return view;
    }

    private void addListeners() {
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implicit Intent
                String googleSearchString = String.format("http://google.com.vn/search?q=%s", food.getAddress());

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchString));
                startActivity(intent);
            }
        });
    }

    public void setFood(Food food) {
        this.food = food;
    }

    private void setupUI() {
        tvTitle.setText(food.getTitle());
        tvAddress.setText(food.getAddress());
        tvDescription.setText(food.getDescription());
    }

    private void getReferences(View view) {
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvAddress = (TextView) view.findViewById(R.id.tv_address);
        tvDescription = (TextView) view.findViewById(R.id.tv_descripstion);
    }
}
