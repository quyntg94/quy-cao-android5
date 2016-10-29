package quyntg.vn.session11.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quyntg.vn.session11.Managers.Preferences;
import quyntg.vn.session11.Models.FragmentEvent;
import quyntg.vn.session11.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.et_username)
    EditText etUsername;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_save) public void onClick(View view){
        //1. get String from et username
        String username = etUsername.getText().toString();
        //2. save data to ShareReference
        Preferences.getInstance().putUsername(username);
        //3. Transit to Quote Fragment
        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(), false
        ));
    }
}
