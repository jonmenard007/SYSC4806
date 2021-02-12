import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.accessingdatajpa.AddressBook;
import com.example.accessingdatajpa.BuddyInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;



public class AddressBookJPATest {

    @Test
    public void preformJPATestOnBuddyInfo(){

      BuddyInfo buddy = new BuddyInfo();
      buddy.setId(1);
      buddy.setFirstName("Jon");
      buddy.setLastName("Menard");
      buddy.setPhoneNumber("111-111-1111");

      EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
      EntityManager em = emf.createEntityManager();

      EntityTransaction tx = em.getTransaction();

      // transaction begins
      tx.begin();

      em.persist(buddy);

      tx.commit();
      // transaction concluded
      Query q = em.createQuery("SELECT b from BuddyInfo b");

      @SuppressWarnings("unchecked")
      List<BuddyInfo> results = q.getResultList();

      System.out.println("List of BuddyInfos \n ---------------");



      BuddyInfo returnedBuddy =  results.get(0);
      System.out.println(returnedBuddy.getInfoString());
      // checking if the buddy returned is the same as the one persisted;
      assertEquals(buddy,returnedBuddy);
      assertEquals(buddy.getId(),returnedBuddy.getId());
      assertEquals(buddy.getFirstName(),returnedBuddy.getFirstName());
      assertEquals(buddy.getLastName(),returnedBuddy.getLastName());
      assertEquals(buddy.getPhoneNumber(),returnedBuddy.getPhoneNumber());



      em.close();
      emf.close();
    }

  @Test
  public void preformJPATestOnAddressBook(){

    BuddyInfo buddy = new BuddyInfo();
    buddy.setId(1);
    buddy.setFirstName("Jon");
    buddy.setLastName("Menard");
    buddy.setPhoneNumber("111-111-1111");

    BuddyInfo buddy2 = new BuddyInfo();
    buddy2.setId(2);
    buddy2.setFirstName("Patrick");
    buddy2.setLastName("Bell");
    buddy2.setPhoneNumber("111-111-1112");


    BuddyInfo buddy3 = new BuddyInfo();
    buddy3.setId(3);
    buddy3.setFirstName("Karter");
    buddy3.setLastName("Hicking");
    buddy3.setPhoneNumber("111-111-1113");


    AddressBook addressBook = new AddressBook();


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

    // transaction begins
    tx.begin();



    em.persist(buddy);
    em.persist(buddy2);
    em.persist(buddy3);
    addressBook.addContact(buddy);
    addressBook.addContact(buddy2);
    addressBook.addContact(buddy3);

    em.persist(addressBook);

    tx.commit();
    // transaction concluded
    Query q = em.createQuery("SELECT b from BuddyInfo b");

    @SuppressWarnings("unchecked")
    List<BuddyInfo> results = q.getResultList();

    System.out.println("List of BuddyInfos \n ---------------");

    for (BuddyInfo b : results) {

      System.out.println(b.getInfoString());
    }

    Query q2 = em.createQuery("select addressBook from AddressBook addressBook");
    List<AddressBook> results2 = q2.getResultList();

    System.out.println("\n \n List of AddressBook \n ---------------");

    for (AddressBook a : results2) {
     ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>( (Collection) a.getAddressBook());
      System.out.println("AddressBook Contains \n ---------------");
      for (BuddyInfo b : buddies) {
        System.out.println(b.getInfoString());
      }
    }





    em.close();
    emf.close();
  }

  @Test
  public void preformJPATestOnAddressBookCascade(){

    BuddyInfo buddy = new BuddyInfo();
    buddy.setFirstName("Jon");
    buddy.setLastName("Menard");
    buddy.setPhoneNumber("111-111-1111");

    BuddyInfo buddy2 = new BuddyInfo();

    buddy2.setFirstName("Patrick");
    buddy2.setLastName("Bell");
    buddy2.setPhoneNumber("111-111-1112");


    BuddyInfo buddy3 = new BuddyInfo();

    buddy3.setFirstName("Karter");
    buddy3.setLastName("Hicking");
    buddy3.setPhoneNumber("111-111-1113");


    AddressBook addressBook = new AddressBook();
    addressBook.addContact(buddy);
    addressBook.addContact(buddy2);
    addressBook.addContact(buddy3);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

    // transaction begins
    tx.begin();




    em.persist(addressBook);

    tx.commit();
    // transaction concluded

    Query q2 = em.createQuery("select addressBook from AddressBook addressBook");

    @SuppressWarnings("unchecked")
    List<AddressBook> results2 = q2.getResultList();

    System.out.println("\n \n List of AddressBook \n ---------------");

    for (AddressBook a : results2) {
      ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>( (Collection) a.getAddressBook());
      System.out.println("AddressBook Contains \n ---------------");
      for (BuddyInfo b : buddies) {
        System.out.println(b.getInfoString());
      }
    }





    em.close();
    emf.close();
  }
}
