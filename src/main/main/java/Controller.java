import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private AddressBook addressBook;
    private View view;

    public Controller() {

    }


    public Controller(View v, AddressBook a) {
        addressBook = a;
        view = v;
        v.addActionListeners(this);
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void addBuddy(String firstname, String lastname, String phone){
        view.resetText();

        BuddyInfo newBuddy = new BuddyInfo(firstname, lastname, phone);
        addressBook.addContact(newBuddy);
        view.addBuddies(newBuddy.getInfoString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            e.getSource();
            String firstname = view.getFirstnameText();
            String lastname = view.getLastnameText();
            String phone = view.getPhoneText();

            view.resetText();

            BuddyInfo newBuddy = new BuddyInfo(firstname, lastname, phone);
            addressBook.addContact(newBuddy);
            view.addBuddies(newBuddy.getInfoString());
    }
}
