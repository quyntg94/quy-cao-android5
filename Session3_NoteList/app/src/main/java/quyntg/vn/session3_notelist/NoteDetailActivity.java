package quyntg.vn.session3_notelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteDetailActivity extends AppCompatActivity {

    public static final String CLICK = "Click";
    private EditText et_note;
    private EditText et_title;
    private Button bt_save;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        getReferences();
        addListeners();
    }

    public void getReferences() {
        et_note = (EditText) findViewById(R.id.et_note);
        et_title = (EditText) findViewById(R.id.et_title) ;
        bt_save = (Button) findViewById(R.id.bt_save);
        Intent intent = getIntent();
        index = intent.getIntExtra("Click", -1);
        if (index != -1) {
            et_title.setText(NoteListActivity.titleList.get(index));
            et_note.setText(NoteListActivity.noteList.get(index));
        }
    }

    private void addListeners() {
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_title.getText().length() > 0) {
                    if (index != -1) {
                        NoteListActivity.titleList.set(index, " " + et_title.getText().toString());
                        NoteListActivity.noteList.set(index, et_note.getText().toString());
                    } else {
                        NoteListActivity.titleList.add(" " + et_title.getText().toString());
                        NoteListActivity.noteList.add(et_note.getText().toString());
                    }
                }
                finish();


            }
        });
    }
}
