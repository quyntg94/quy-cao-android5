package quyntg.vn.session5_contact;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ContactDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "Contact";
    private static final String TAG = ContactDetailActivity.class.toString();

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        getDataFromIntent();
        onDetailFragment();
        getReferences();
        setupUI();
    }

    private void onDetailFragment() {
        ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
        contactDetailFragment.setContact(contact);

        //1
        FragmentManager fragmentManager = getSupportFragmentManager();
        //2
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_contact_detail_container, contactDetailFragment);
        //3
        fragmentTransaction.addToBackStack(null);
        //4
        fragmentTransaction.commit();
    }

    private void setupUI() {

    }

    private void getReferences() {

    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        contact = (Contact) intent.getSerializableExtra(EXTRA_CONTACT);
        Log.d(TAG, contact.getTitle());

    }
}
