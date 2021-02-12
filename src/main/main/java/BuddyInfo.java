import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity
public class BuddyInfo {

    @Id
    private Integer id = null;

    private String firstname = null;
    private String lastName = null;
    private String phoneNumber;

    public BuddyInfo() {

    }

    public BuddyInfo(String firstname, String lastName){
        this(firstname,lastName,null);
    }

    public BuddyInfo(String firstname, String lastName, String phoneNumber) {
        setFirstname(firstname);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfoString(){
        return getFirstname() + " " + getLastName() + " " + getPhoneNumber();
    }

    @Override
    public String toString(){
        return getFirstname() + " " + getLastName() + " " + getPhoneNumber();
    }


}
