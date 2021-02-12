package com.example.accessingdatajpa;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class AddressBook  {


    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> addressBook = new ArrayList<BuddyInfo>();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long addressbookId;



    public AddressBook() {

    }

    public AddressBook(List<BuddyInfo> b) {
        this.addressBook = b;
    }

    public void setAddressbookId(Long id) {
        this.addressbookId = id;
    }

    public Long getAddressbookId() {
        return addressbookId;
    }


    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo> a) {
       // this.addressBook = a.stream().collect(Collectors.toCollection(ArrayList::new));
        this.addressBook = new ArrayList<>(a);
    }


    public int getSize(){
        return addressBook.size();
    }

    public void addContact(BuddyInfo contact){
        addressBook.add(contact);
    }

    public void addBuddyInfo(BuddyInfo buddyInfo){
        addressBook.add(buddyInfo);
    }

    public void addBuddyInfo(String firstName, String lastName, String phoneNumber){
        BuddyInfo buddyInfo = new BuddyInfo();
        addressBook.add(buddyInfo);
        System.out.print(buddyInfo.toString());
    }

    public int findContact(String firstname, String lastname){
        for(int i = 0; i < addressBook.size(); i++){
            BuddyInfo b = addressBook.get(i);
        //    if(b.getFirstName().equals(firstname) && b.getLastName().equals(lastname)){
                return i;
          //  }
        }
        return -1;
    }

    public BuddyInfo getContact(int index){
        return addressBook.get(index);
    }

    public BuddyInfo getContact(String firstname, String lastname){
        int index = findContact(firstname,lastname);
        if(index != -1){
            return getContact(index);
        }
        return null;
    }


    public BuddyInfo deleteContact(int index){
        return addressBook.remove(index);
    }

    public BuddyInfo deleteContact(String firstname, String lastname){
        int index = findContact(firstname,lastname);
        if(index != -1){
            return deleteContact(index);
        }
        return null;
    }

    public String printBuddyInfo(String firstname, String lastname){
        int index = findContact(firstname,lastname);
        if(index != -1){
            return printBuddyInfo(index);
        }
        return "";
    }

    public String printBuddyInfo(int i){
        BuddyInfo b = getContact(i);
        String info = "";
        if(b != null){
          //  info = b.getInfoString();
            System.out.println(info);
        }
        return info;
    }

    public String printAll(){
        String allInfo = "";
        for(int i = 0; i < addressBook.size(); i++){
            allInfo += printBuddyInfo(i) + "\n";
        }
        return allInfo;
    }

    @Override
    public String toString(){
        String allInfo = "";
        for(int i = 0; i < addressBook.size(); i++){
            allInfo += addressBook.get(i).toString() + "\n";
        }
        return allInfo;
    }

    public ArrayList<String> toStringArray(){
        ArrayList<String> buddyString = new ArrayList<String>();
        for(int i = 0; i < addressBook.size(); i++){
            buddyString.add(addressBook.get(i).toString());
        }
        return buddyString;
    }


//    public static void main(String[] args) {
//        AddressBook addressBook = new AddressBook();
//
//        BuddyInfo buddy1 = new BuddyInfo("Jon", "Menard", "111-111-1111");
//        buddy1.setId(1);
//        BuddyInfo buddy2 = new BuddyInfo("Sean", "Vander-Glas", "111-111-2222");
//        buddy2.setId(2);
//        BuddyInfo buddy3 = new BuddyInfo("Patrick", "Bell", "111-111-3333");
//        buddy3.setId(3);
//        BuddyInfo buddy4 = new BuddyInfo("Hannah", "Cavanagh", "111-111-4444");
//        buddy4.setId(4);
//        BuddyInfo buddy5 = new BuddyInfo("Caitlin", "Porter", "111-111-5555");
//        buddy5.setId(5);
//
//        addressBook.addContact(buddy1);
//        addressBook.addContact(buddy2);
//        addressBook.addContact(buddy3);
//        addressBook.addContact(buddy4);
//        addressBook.addContact(buddy5);
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//
//        // transaction begins
//        tx.begin();
//
//
//
//
//        em.persist(addressBook);
//
//        tx.commit();
//        // transaction concluded
//
//        Query q2 = em.createQuery("select addressBook from AddressBook addressBook");
//
//        @SuppressWarnings("unchecked")
//        List<AddressBook> results2 = q2.getResultList();
//
//        System.out.println("List of AddressBook \n ---------------");
//
//        for (AddressBook a : results2) {
//            System.out.println("AddressBook Contains \n --------------- ");
//            a.printAll();
//        }
//
//
//    }


}