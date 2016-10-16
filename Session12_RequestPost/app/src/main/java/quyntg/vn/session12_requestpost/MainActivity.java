package quyntg.vn.session12_requestpost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRequest();
    }

    private void getRequest() {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("HUY", "O N E S H O T")
                .build();
        Request request = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, body);
            }
        });
    }
}
