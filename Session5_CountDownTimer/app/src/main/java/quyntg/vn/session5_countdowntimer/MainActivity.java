package quyntg.vn.session5_countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView coutDownTime;
    private long currentTime;
    private long defaultTime = 30000;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        if( savedInstanceState != null ) {
            currentTime = savedInstanceState.getLong("millisKey");
            countDown(currentTime);
        } else{
            countDown(defaultTime);
        }

    }

    private void countDown(long time){
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
                coutDownTime.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                coutDownTime.setText("done!");
            }
        }.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisKey", currentTime);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentTime = savedInstanceState.getLong("millisKey");
    }

    private void getReferences() {
        coutDownTime = (TextView) findViewById(R.id.tv_countDownTimer);
    }



}
