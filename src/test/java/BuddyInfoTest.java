import com.example.accessingdatajpa.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo buddy;
    BuddyInfo buddy2;

    @Before
    public void setUp(){
        buddy = new BuddyInfo("Jon", "Menard");
        buddy2 = new BuddyInfo("Patrick", "Bell", "222-222-2222");
    }

    @Test
    public void testCreateBuddyInfo(){
        assertEquals(BuddyInfo.class,buddy.getClass());
    }

    @Test
    public void testGetFirstName(){
        assertEquals("Jon",buddy.getFirstName());
    }

    @Test
    public void testChangeFirstName(){
        buddy.setFirstName("Jonathan");
        assertEquals("Jonathan",buddy.getFirstName());
    }

    @Test
    public void testGetLastName(){
        assertEquals("Menard",buddy.getLastName());
    }

    @Test
    public void testChangeLastName(){
        buddy.setLastName("Simpson");
        assertEquals("Simpson",buddy.getLastName());
    }

    @Test
    public void testGetUnsetPhone(){
        assertNull(buddy.getPhoneNumber());
    }

    @Test
    public void testSetPhone(){
        buddy.setPhoneNumber("111-111-1111");
        assertEquals("111-111-1111", buddy.getPhoneNumber());
    }

    @Test
    public void testGetInfo(){
        assertEquals("Jon Menard null", buddy.getInfoString());
        assertEquals("Patrick Bell 222-222-2222", buddy2.getInfoString());
    }

}