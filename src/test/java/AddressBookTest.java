import org.junit.Before;
import org.junit.Test;

import com.example.accessingdatajpa.AddressBook;
import com.example.accessingdatajpa.BuddyInfo;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    BuddyInfo buddy;
    BuddyInfo buddy2;

    AddressBook addressBook;

//    @Before
//    public void setUp(){
//        buddy = new BuddyInfo("Jon", "Menard");
//        buddy2 = new BuddyInfo("Patrick", "Bell", "222-222-2222");
//        addressBook = new AddressBook();
//    }
//
//    @Test
//    public void testCreateAddressBook(){
//        assertEquals(AddressBook.class,addressBook.getClass());
//    }
//
//    @Test
//    public void testEmptyAddressBookSize(){
//        assertEquals(0,addressBook.findAddressBookSize());
//    }
//
//    @Test
//    public void testAddContact(){
//        addressBook.addContact(buddy);
//        assertEquals(1,addressBook.findAddressBookSize());
//        addressBook.addContact(buddy2);
//        assertEquals(2,addressBook.findAddressBookSize());
//    }
//
//
//    @Test
//    public void testFindContactByName(){
//        addressBook.addContact(buddy);
//        assertEquals(0,addressBook.findContact("Jon","Menard"));
//    }
//
//    @Test
//    public void testGetContactByIndex(){
//        addressBook.addContact(buddy);
//        assertEquals(buddy,addressBook.getContact(0));
//    }
//
//    @Test
//    public void testGetContactByName(){
//        addressBook.addContact(buddy);
//        assertEquals(buddy,addressBook.getContact("Jon","Menard"));
//    }
//
//    @Test
//    public void testDeleteContactByIndex(){
//        addressBook.addContact(buddy);
//        assertEquals(buddy,addressBook.deleteContact(0));
//        assertEquals(0,addressBook.findAddressBookSize());
//    }
//
//    @Test
//    public void testDeleteContactByName(){
//        addressBook.addContact(buddy);
//        assertEquals(buddy,addressBook.deleteContact("Jon","Menard"));
//        assertEquals(0,addressBook.findAddressBookSize());
//    }
//
//    @Test
//    public void testPrintContactByIndex(){
//        addressBook.addContact(buddy);
//        assertEquals("Jon Menard null",addressBook.printBuddyInfo(0));
//    }
//
//    @Test
//    public void testPrintContactByName(){
//        addressBook.addContact(buddy);
//        assertEquals("Jon Menard null",addressBook.printBuddyInfo("Jon","Menard"));
//    }
//
//    @Test
//    public void testPrintAllContact(){
//        addressBook.addContact(buddy);
//        addressBook.addContact(buddy2);
//        assertEquals("Jon Menard null\nPatrick Bell 222-222-2222\n",addressBook.printAll());
//    }






}