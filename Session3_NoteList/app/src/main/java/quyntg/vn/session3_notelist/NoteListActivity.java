package quyntg.vn.session3_notelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteListActivity extends AppCompatActivity {

    private static final String TAG = NoteListActivity.class.toString();

    private static String[] LIST_TITLE = new String[]{"RED", "BLUE", "YELLOW"};
    private static String[] LIST = new String[]{"GREEN", "PINK", "GOLD"};


    public static ArrayList<String> noteList =  new ArrayList<>(Arrays.asList(LIST));
    public static ArrayList<String> titleList = new ArrayList<>(Arrays.asList(LIST_TITLE));

    private ListView lvNoteList;
    private Button btAdd;
    private ArrayAdapter<String> noteListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.activity_note_list);
        //2
        getReferences();
        // 3
        setupUIProperties();
        //4
        addListeners();
    }

    private void setupUIProperties() {
        // 1
        noteListAdapter = new ArrayAdapter<>(
                this,
                R.layout.simple_list_item,
                titleList);

        // 2
        lvNoteList.setAdapter(noteListAdapter);
    }

    private void getReferences() {
        lvNoteList = (ListView) findViewById(R.id.lv_notelist);
        btAdd = (Button) findViewById(R.id.bt_add);
    }

    private void addListeners() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1
                Intent intent = new Intent(NoteListActivity.this, NoteDetailActivity.class);

                // 2
                startActivity(intent);
                //3
                Log.d(TAG, "onClick");
            }
        });

        lvNoteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                Log.d(TAG, String.format("onItemLongClick: %d", position));
                noteList.remove(position);
                titleList.remove(position);
                noteListAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lvNoteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("onItemClick: %d", position));
                // 1
                Intent intent = new Intent(NoteListActivity.this, NoteDetailActivity.class);

                // 2
                intent.putExtra(NoteDetailActivity.CLICK, position);
                //3
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        noteListAdapter.notifyDataSetChanged();
    }
}
