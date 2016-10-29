package quyntg.vn.session11.Fragments;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import quyntg.vn.session11.Jsonmodels.QuoteJSONModel;
import quyntg.vn.session11.Managers.FileManager;
import quyntg.vn.session11.Managers.Preferences;
import quyntg.vn.session11.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString() ;
    @BindView(R.id.iv_background)
    ImageView ivBackground;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_username) TextView tvUsername;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void updateQuote(final QuoteJSONModel quoteJSONModel){
        Activity parent = getActivity();

        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quoteJSONModel.getTitle());
                tvContent.setText(Html.fromHtml(quoteJSONModel.getContent()));
            }
        });
    }

    private void setupUI() {
        //Username
        tvUsername.setText(String.format("Hi, %s", Preferences.getInstance().getUsername()));

        String unplash = "unplash";
        File file = FileManager.getInstance().loadImageFile(unplash);
        ImageLoader.getInstance().displayImage(
                Uri.fromFile(file).toString(), ivBackground
        );
//        ImageLoader.getInstance().loadImage(Constant.UNPLASH_API, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
////                FileManager.getInstance().createImage(loadedImage, "unplash");
////                Log.d(TAG, "Load image completed");
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//            }
//        });
        //Image
//        ImageLoader.getInstance().displayImage(Constant.UNPLASH_API, ivBackground);
//            //1 create client
//            OkHttpClient client = new OkHttpClient();
//            //2 create request
//            final Request request = new Request.Builder().url(Constant.QUOTE_API).build();
//            //3 send a handle
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    Log.d(TAG, "onFailure");
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    //4
//                    Log.d(TAG, "onResponse");
//                    String bodyString = response.body().string();
//                    Log.d(TAG, String.format("ResponseBody: %s", bodyString));
//
//                    //create gson
//                    Gson gson = new Gson();
//                    //parse
//                    QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);
//
//                    if(quotes.length > 0){
//                        QuoteFragment.this.updateQuote(quotes[0]);
//
//                    }
//                }
//        });

    }


}
