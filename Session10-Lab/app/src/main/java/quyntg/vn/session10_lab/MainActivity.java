package quyntg.vn.session10_lab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public String[] LIST = new String[]{
            "07.02", "08.02", "08.05", "09.01", "09.02"
    };

    private ArrayList<String> arrayList =
            new ArrayList<>(Arrays.asList(LIST));

    private ListView lvSimple;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUI();
        addListeners();
    }

    private void getReferences() {
        lvSimple = (ListView) (findViewById(R.id.lv_simple));
    }

    private void setupUI() {
        //1
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,
                arrayList
        );

        //2
        lvSimple.setAdapter(adapter);
    }

    private void addListeners() {
        lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                switch (position){
                    case 0:
                        Fragment01 detailFragment = new Fragment01();
                        fragmentTransaction.replace(R.id.fl_simple, detailFragment);
                        break;
                    case 1:
                        Fragment02 detailFragment2 = new Fragment02();
                        fragmentTransaction.replace(R.id.fl_simple, detailFragment2);
                        break;
                    case 2:
                        Fragment03 detailFragment3 = new Fragment03();
                        fragmentTransaction.replace(R.id.fl_simple, detailFragment3);
                        break;
                    case 3:
                        Fragment04 detailFragment4 = new Fragment04();
                        fragmentTransaction.replace(R.id.fl_simple, detailFragment4);
                        break;
                    case 4:
                        Fragment05 detailFragment5 = new Fragment05();
                        fragmentTransaction.replace(R.id.fl_simple, detailFragment5);
                        break;

                }



                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();


            }
        });
    }
}
