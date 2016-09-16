package quyntg.vn.session3_activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    private static final String TAG = ActivityA.class.toString();

    private TextView tv_onCreate;
    private TextView tv_onStart;
    private TextView tv_onRestart;
    private TextView tv_onResume;
    private TextView tv_onPause;
    private TextView tv_onStop;
    private TextView tv_onDestroy;
    private Button bt_goto;

    private int onCreateCount = 0;
    private int onStartCount = 0;
    private int onRestartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onStopCount = 0;
    private int onDestroyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        onCreateCount++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_a);


        getLayoutReferences();
        onCout();
        bt_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() { //visible
        super.onStart();
        Log.d(TAG, "onStart");
        onStartCount++;
        onCout();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
        onRestartCount++;
        onCout();
    }

    @Override
    protected void onResume() { // active
        super.onResume();
        Log.d(TAG, "onResume");
        onResumeCount++;
        onCout();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        onPauseCount++;
        onCout();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        onStopCount++;
        onCout();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        onDestroyCount++;
        onCout();
    }

    void onCout(){
        tv_onCreate.setText(String.format("onCreate: %d", onCreateCount));
        tv_onStart.setText(String.format("onStart: %d" , onStartCount));
        tv_onRestart.setText(String.format("onRestart: %d" , onRestartCount));
        tv_onResume.setText(String.format("onResume: %d" , onResumeCount));
        tv_onPause.setText(String.format("onPause: %d" , onPauseCount));
        tv_onStop.setText(String.format("onStop: %d" , onStopCount));
        tv_onDestroy.setText(String.format("onDestroy: %d" , onDestroyCount));
    }

    void getLayoutReferences(){
        tv_onCreate = (TextView) findViewById(R.id.tv_onCreate);
        tv_onStart = (TextView) findViewById(R.id.tv_onStart);
        tv_onRestart = (TextView) findViewById(R.id.tv_onRestart);
        tv_onResume = (TextView) findViewById(R.id.tv_onResume);
        tv_onPause = (TextView) findViewById(R.id.tv_onPause);
        tv_onStop = (TextView) findViewById(R.id.tv_onStop);
        tv_onDestroy = (TextView) findViewById(R.id.tv_onDestroy);
        bt_goto = (Button) findViewById(R.id.bt_go);
    }
}
