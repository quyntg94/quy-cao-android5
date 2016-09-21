package quyntg.vn.session5_contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giaqu on 9/21/2016.
 */
public class Contact implements Serializable{

    private String title;
    private String phone;
    private String link;

    /*"FPT Software", "0473007575", "https://www.fpt-software.com"
    "EWay", "+84432595450", "https://eway.vn"
    "KMS", "+84838486888", "http://www.kms-technology.com"
    "BraveBits", " +84463260066", "http://www.bravebits.vn"
"   TechKids", "+841653005670", "http://techkids.vn"
    */

    private static List<Contact> contactList;

    public static synchronized List<Contact> getContactList(){
        if(contactList == null){
            contactList = new ArrayList<>();
            contactList.add(new Contact("FPT Software", "0473007575", "https://www.fpt-software.com"));
            contactList.add(new Contact("EWay", "+84432595450", "https://eway.vn"));
            contactList.add(new Contact("KMS", "+84838486888", "http://www.kms-technology.com"));
            contactList.add(new Contact("BraveBits", " +84463260066", "http://www.bravebits.vn"));
            contactList.add(new Contact("TechKids", "+841653005670", "http://techkids.vn"));
        }
        return contactList;
    }

    public static void setContactList(List<Contact> contactList) {
        Contact.contactList = contactList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Contact(String title, String link, String phone) {

        this.title = title;
        this.link = link;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
