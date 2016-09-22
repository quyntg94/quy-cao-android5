package quyntg.vn.session5_contact;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailFragment extends Fragment {


    private Contact contact;

    private TextView tvTitle;
    private TextView tvPhone;
    private TextView tvLink;

    public ContactDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        getReferences(view);
        setupUI();
        addListeners();
        return view;
    }

    private void addListeners() {
        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Implicit Intent
                String link = String.format("%s", contact.getLink());

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });
        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = String.format("tel: " + contact.getPhone().trim());
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phone));
                startActivity(intent);
            }
        });
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    private void setupUI() {
        tvTitle.setText(contact.getTitle());
        tvPhone.setText(contact.getPhone());
        tvLink.setText(contact.getLink());
    }

    private void getReferences(View view) {
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvLink = (TextView) view.findViewById(R.id.tv_link);
    }

}
