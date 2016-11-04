package quyntg.vn.session18_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import quyntg.vn.session18_login.jsonmodels.LoginAccount;
import quyntg.vn.session18_login.jsonmodels.ResultLogin;
import quyntg.vn.session18_login.network.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @OnClick (R.id.btn_login) public void login(){

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Retrofit retrofit = new Retrofit.
                Builder().baseUrl("https://a5-tumblelog.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginAccount loginAccount = new LoginAccount(username, password);
        String jsonBody = new Gson().toJson(loginAccount);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        LoginService loginService = retrofit.create(LoginService.class);
        loginService.login(requestBody).enqueue(new Callback<ResultLogin>() {
            @Override
            public void onResponse(Call<ResultLogin> call, Response<ResultLogin> response) {
                Log.d(TAG,"onResponse");

                ResultLogin resultLogin = response.body();
                boolean result = resultLogin.isSuccessful();
                if (result) {
                    Toast.makeText(MainActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Log In Not Successful", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<ResultLogin> call, Throwable t) {
                Log.d(TAG,"onFailure");

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        login();
    }
}
