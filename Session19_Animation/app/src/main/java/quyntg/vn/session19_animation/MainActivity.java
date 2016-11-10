package quyntg.vn.session19_animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private View iView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iView = findViewById(R.id.v_item);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit)
                .replace(R.id.fl_container, new InFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mi_animate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.d(TAG, "onMenuItemClick");
//                translate_scale();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.translate_alphaa, R.anim.translate_alpha)
                        .replace(R.id.fl_container, new OutFragment())
                        .commit();
                return false;
            }
        });
        
        return true;
    }


    void translate(){
        //1: Create animation
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 100,
                0, 0);
        translateAnimation.setDuration(300);

        translateAnimation.setFillAfter(true);

        translateAnimation.setInterpolator(new LinearInterpolator());
        //2: Animate
        iView.startAnimation(translateAnimation);
    }

    void translateByXML(){
        //1: load animation for XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_to_right);

        iView.startAnimation(animation);
        //2:
    }

    void rotate(){
        //1: Create animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);

        //2: animate
        iView.startAnimation(rotateAnimation);
    }

    void rotateByXML(){
        //1: load animation for XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        iView.startAnimation(animation);
        //2:
    }

    void scale(){
        //1: Create animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 2,
                1, 2,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);

        iView.startAnimation(scaleAnimation);

    }

    void alpha(){
        //1: create animation
        AlphaAnimation alphaAnimation = new AlphaAnimation(
                1, 0
        );

        alphaAnimation.setDuration(300);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        //2: animate

        iView.startAnimation(alphaAnimation);
    }

    void scaleByXML(){
        //1: load animation for XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);

        iView.startAnimation(animation);
        //2:
    }

    void alphaByXML(){
        //1: load animation for XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        iView.startAnimation(animation);
        //2:
    }

    void translate_alpha(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_alpha);

        iView.startAnimation(animation);
    }

    void translate_scale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_scale);

        iView.startAnimation(animation);
    }


}
