package quyntg.vn.session2_flashlight;

import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import techkids.vn.session2.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private Camera camera;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        //1
        getCamera();
        //2
        setContentView(R.layout.activity_main);
        //3
        getReferences();
        //4
        addListeners();
    }

    private void getCamera(){
        try{
            camera = Camera.open();
        }
        catch (RuntimeException e){
            Log.e(TAG, String.format("Could not open camera: %s", e.getMessage()));
        }
    }

    private void getReferences(){
        tgFlashLight = (ToggleButton) findViewById(R.id.tb_flash_light);
        background = (RelativeLayout) findViewById(R.id.background);
    }

    private void addListeners(){
        tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.d(TAG, String.format("tgbFlashLight check changed : %s", isChecked));
                if (isChecked) {
                    // 1
                    Camera.Parameters params = camera.getParameters();

                    // 2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                    // 3
                    camera.setParameters(params);
                    background.setBackgroundColor(Color.WHITE);
                } else {
                    // 1
                    Camera.Parameters params = camera.getParameters();

                    // 2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

                    // 3
                    camera.setParameters(params);
                    background.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }

    @Override
    protected void onStart() { //visible
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() { // active
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
