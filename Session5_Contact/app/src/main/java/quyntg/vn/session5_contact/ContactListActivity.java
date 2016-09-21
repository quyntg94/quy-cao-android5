package quyntg.vn.session5_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ContactListActivity extends AppCompatActivity {

    private List<Contact> contactList;

    private ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.activity_contact_list);
        initData();
        //2
        getReferences();
        //3
        setupUI();
        //4
        addListeners();
    }

    private void getReferences() {
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }

    private void initData() {
        contactList = Contact.getContactList();
    }

    private void setupUI(){
        //1
        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<Contact>(
                this, android.R.layout.simple_list_item_1,
                contactList
        );

        //2
        lvContact.setAdapter(contactAdapter);
    }

    private void addListeners(){
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contact contact = contactList.get(position);

                if(findViewById(R.id.fl_container) == null) {
                    //Large and Normal Screen
                    Intent intent = new Intent(ContactListActivity.this, ContactDetailActivity.class);

                    intent.putExtra(ContactDetailActivity.EXTRA_CONTACT, contact);

                    startActivity(intent);
                } else {
                    //Xlarge Screen
                    ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
                    contactDetailFragment.setContact(contact);

                    //1
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    //2
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.fl_container, contactDetailFragment);
                    //3
                    fragmentTransaction.addToBackStack(null);
                    //4
                    fragmentTransaction.commit();
                }
            }
        });
    }
}
