
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class View extends JFrame{


    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField phoneTextField;
    private JComboBox<String> addressBookDropDown;
    private JButton submit;


    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(600, 300);

        setVisible(true);
        setState(Frame.NORMAL);

    }


    public View(){

    }

    public View(JTextField firstnameTextField,JTextField lastnameTextField, JTextField phoneTextField, JComboBox<String> addressBookDropDown, JButton submit) {
        this.firstnameTextField = firstnameTextField;
        this.lastnameTextField = lastnameTextField;
        this.phoneTextField = phoneTextField;
        this.addressBookDropDown = addressBookDropDown;
        this.submit = submit;

        setMinimumSize(new Dimension(600,300));
        setMaximumSize(new Dimension(600,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void setFirstnameTextField(JTextField firstnameTextField) {
        this.firstnameTextField = firstnameTextField;
    }

    public void setLastnameTextField(JTextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }

    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    public void setAddressBookDropDown(JComboBox<String> addressBookDropDown) {
        this.addressBookDropDown = addressBookDropDown;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public void addActionListeners(ActionListener listener){
        submit.addActionListener(listener);
    }

    public String getFirstnameText() {
        return firstnameTextField.getText();
    }

    public String getLastnameText() {
        return lastnameTextField.getText();
    }


    public String getPhoneText() {
        return phoneTextField.getText();
    }

    public void resetText(){
        firstnameTextField.setText(null);
        lastnameTextField.setText(null);
        phoneTextField.setText(null);
    }

    public void addBuddies(String  newBuddie){
        addressBookDropDown.addItem(newBuddie);
        this.repaint();
    }


    public static void main(String args[]){

        // View Related Activities




//        JPanel mainDisplay = new JPanel(new BorderLayout());
//        JPanel center = new JPanel(new GridLayout(2, 1));
//        JPanel textPanel = new JPanel(new GridLayout(4, 2));
//        JPanel addressBookDisplay = new JPanel(new GridLayout(2, 1));
//
//        JLabel contactListLabel = new JLabel("Contact List");
//        JComboBox<String> addressBookDropDown = new JComboBox<String>(new String[] {});
//        addressBookDisplay.add(contactListLabel);
//        addressBookDisplay.add(addressBookDropDown);
//
//        JLabel firstnameLabel = new JLabel("Firstname");
//        JTextField firstnameTextField = new JTextField(20);
//        JLabel lastnameLabel = new JLabel("Lastname");
//        JTextField lastnameTextField = new JTextField(20);
//        JLabel phoneLabel = new JLabel("Phone");
//        JTextField phoneTextField = new JTextField(20);
//        JButton submit = new JButton("Add Contact");
//
//
//        textPanel.add(firstnameLabel);
//        textPanel.add(firstnameTextField);
//        textPanel.add(lastnameLabel);
//        textPanel.add(lastnameTextField);
//        textPanel.add(phoneLabel);
//        textPanel.add(phoneTextField);
//        center.add(textPanel);
//        center.add(submit);
//
//
//        mainDisplay.add(center, BorderLayout.CENTER);
//        // mainDisplay.add(submit,BorderLayout.CENTER);
//        mainDisplay.add(addressBookDisplay, BorderLayout.PAGE_END);
//
//        View view = new View(firstnameTextField,lastnameTextField, phoneTextField, addressBookDropDown, submit);
//        view.add(mainDisplay);
//        view.pack();
//        view.setVisible(true);
//        view.setSize(600, 300);
//
//        AddressBook addressBook = new AddressBook();
//        Controller c = new Controller(view ,addressBook);


        // above is old code --- this is the new implementation
        Launcher launcher = new Launcher();
        launcher.launch();
    }

}
