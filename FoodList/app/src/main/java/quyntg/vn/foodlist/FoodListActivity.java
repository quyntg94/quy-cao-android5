package quyntg.vn.foodlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    private List<Food> foodList;

    private ListView lvFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.activity_food_list);
        initData();
        //2
        getReferences();
        //3
        setupUI();
        //4
        addListeners();
    }

    private void initData() {
        foodList = Food.getFoodList();
    }

    private void setupUI(){
        //1
        ArrayAdapter<Food> foodAdapter = new ArrayAdapter<Food>(
                this, android.R.layout.simple_list_item_1,
                foodList
        );

        //2
        lvFood.setAdapter(foodAdapter);
    }

    private void getReferences(){
        lvFood = (ListView) findViewById(R.id.lv_food);
    }

    private void addListeners(){
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Food food = foodList.get(position);

                if(findViewById(R.id.fl_container) == null) {
                    //Large and Normal Screen
                    Intent intent = new Intent(FoodListActivity.this, FoodDetailActivity.class);

                    intent.putExtra(FoodDetailActivity.EXTRA_FOOD, food);

                    startActivity(intent);
                } else {
                    //Xlarge Screen
                    FoodDetailFragment foodDetailFragment = new FoodDetailFragment();
                    foodDetailFragment.setFood(food);

                    //1
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    //2
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.fl_container, foodDetailFragment);
                    //3
                    fragmentTransaction.addToBackStack(null);
                    //4
                    fragmentTransaction.commit();
                }
            }
        });
    }
}
