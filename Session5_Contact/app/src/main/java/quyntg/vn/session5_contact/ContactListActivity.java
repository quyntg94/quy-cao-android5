package quyntg.vn.session5_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class ContactListActivity extends AppCompatActivity {

    private List<Contact> contactList;

    private ListView lvContact;
    private FrameLayout flContact;

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
        flContact = (FrameLayout) findViewById(R.id.fl_contact_default);

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

                ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
                contactDetailFragment.setContact(contact);

                //1
                FragmentManager fragmentManager = getSupportFragmentManager();
                //2
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(flContact != null){
                    fragmentTransaction.add(R.id.fl_contact_default, contactDetailFragment);
                }else {
                    fragmentTransaction.replace(R.id.fl_container, contactDetailFragment);
                }
                //3
                fragmentTransaction.addToBackStack(null);
                //4
                fragmentTransaction.commit();

            }
        });

    }
}
