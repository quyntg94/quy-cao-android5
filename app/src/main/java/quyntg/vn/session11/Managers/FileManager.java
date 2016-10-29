package quyntg.vn.session11.Managers;

import android.content.Context;
import android.graphics.Bitmap;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by giaqu on 10/18/2016.
 */
public class FileManager {
    private Storage storage;
    private final static String IMAGE_DIR = "images";
    private final static String IMAGE_FILE_FORMAT = "unplash_%s.png";

    private FileManager(Context context){
        storage = SimpleStorage.getInternalStorage(context);
    }

    private static FileManager instance;

    public void createImage(Bitmap bitmap, String filename){
        storage.createFile(IMAGE_DIR, filename, bitmap);
    }

    public File loadImageFile(String fileName){
        return storage.getFile(IMAGE_DIR, fileName);
    }

    public void createImage(Bitmap bitmap, int index){
        createImage(bitmap, String.format(IMAGE_FILE_FORMAT, index));
    }

    public File loadImageFile(int index){
        return loadImageFile(String.format(IMAGE_FILE_FORMAT, index));
    }

    public static FileManager getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new FileManager(context);
    }


}
