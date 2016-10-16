package quyntg.vn.session12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import quyntg.vn.session12.jsonmodels.FlickrItem;
import quyntg.vn.session12.jsonmodels.HolderItem;

public class MainActivity extends AppCompatActivity {

    private ListView lvflickr;
    private ArrayAdapter<FlickrItem> feedArrayAdapter;
    private ArrayList<FlickrItem> flickrItems;
    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrItems = new ArrayList<>();
        getReferences();
        setupUI();
        getContent();
    }

    private void setupUI() {
//        feedArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flickrItems);
//        lvflickr.setAdapter(feedArrayAdapter);
    }


    private void getReferences() {
        lvflickr = (ListView) findViewById(R.id.lvflickr);

    }

    private void getContent() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(
//                "http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl"
                "http://jsonplaceholder.typicode.com/posts"
        ).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                String body = response.body().string().replace("jsonFlickrFeed(","").replace("})", "}");
//                String bodyString = response.body().string().replace("[","").replace("]","");


                String bodyString = response.body().string();
                if(bodyString != null){
                    final HolderItem[] holderItems  = new Gson().fromJson(bodyString, HolderItem[].class);

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//
//                        lvflickr.setAdapter(new FlickrAdapter(getBaseContext(), R.layout.listview, flickrItems));
                            lvflickr.setAdapter(new HolderAdapter(getBaseContext(), R.layout.listview_, holderItems));

//                        }
                        }
                    });
                }
//                final FlickrFeed flickrFeed = new Gson().fromJson(body, FlickrFeed.class);
//
//                final List<FlickrItem> flickrItems = flickrFeed.getItems();

//                Log.d(TAG, flickrFeed.getTitle());
            }
        });
    }
}
