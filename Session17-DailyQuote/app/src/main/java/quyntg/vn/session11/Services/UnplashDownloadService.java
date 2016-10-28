package quyntg.vn.session11.Services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;

import quyntg.vn.session11.Constant.Constant;
import quyntg.vn.session11.Managers.FileManager;
import quyntg.vn.session11.Managers.Preferences;

/**
 * Created by giaqu on 10/26/2016.
 */
public class UnplashDownloadService extends IntentService {

    private static final String TAG = UnplashDownloadService.class.toString();
    private static final int IMAGE_COUNT = 10;

    public UnplashDownloadService() {
        super("UnplashDownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        for(int i = 0; i < 10; i++){
            Log.d(TAG, String.format("Unplash #%s", i));
            Log.d(TAG, "Downloading image");
            //1: Download image
            Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constant.UNPLASH_API);

            Log.d(TAG, "Done Downloading!");

            Log.d(TAG, "Saving downloading image");
            //2: Save
            FileManager.getInstance().createImage(bitmap, i);
            Log.d(TAG, "Done saving");

            Preferences.getInstance().putImageCount(i + 1);
        }
        //3: Mark References

//        while (true){
//            try {
//                Thread.sleep(500);
//                Log.d(TAG, "Blah");
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
    }
}
