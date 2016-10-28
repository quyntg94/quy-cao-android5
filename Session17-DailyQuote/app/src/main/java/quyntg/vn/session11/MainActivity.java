package quyntg.vn.session11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import quyntg.vn.session11.Fragments.LoginFragment;
import quyntg.vn.session11.Fragments.QuoteFragment;
import quyntg.vn.session11.Managers.Preferences;
import quyntg.vn.session11.Models.FragmentEvent;
import quyntg.vn.session11.Services.UnplashDownloadService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString() ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        if(Preferences.getInstance().getUsername() == null) {
            changeFragment(new LoginFragment(), false);
        } else{
            changeFragment(new QuoteFragment(), false);
        }

        /*
        * if(isConnectedToInternet){
        *   loadOnlineData();
        *   prepareOfflineData();
        *}
        * else{
        *   loadOfflineData();
        * }
        * */

//        Storage storage = SimpleStorage.getInternalStorage(this);
////        storage.createFile("text", "quote.txt", "No pain, no gain");
//        String content = storage.readTextFile("text", "quote.txt");
//        Log.d(TAG, String.format("Read done: %s", content));

        Intent intent = new Intent(this, UnplashDownloadService.class);
        startService(intent);
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent){
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment);

        if(addToBackstack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
