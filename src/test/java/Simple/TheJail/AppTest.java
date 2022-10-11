package Simple.TheJail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Simple.TheJail.Dao.AdminDao;
import Simple.TheJail.Dao.TheJailDao;
import Simple.TheJail.Dao.UserDao;
import Simple.TheJail.DaoImpl.AdminDaoImpl;
import Simple.TheJail.DaoImpl.TheJailDaoImpl;
import Simple.TheJail.DaoImpl.UserDaoImpl;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

@Test
@Disabled
public void testregistration() throws GlobalException {
	TheJailDao dao=new TheJailDaoImpl();
	User u1=new User();
	u1.setUserName("Tanuja");
	u1.setUserPhone("9932112345");
	u1.setUserPassword("tanu123");
	u1.setUserAddress("shikaripura");
	u1.setUserRole("student");
	User u2=new User();
	u2.setUserName("Ganesha");
	u2.setUserPhone("9902903420");
	u2.setUserPassword("gana321");
	u2.setUserAddress("Shivamogga");
	u2.setUserRole("student");

	assertAll(
			()->assertEquals(1,dao.Registration(u1)),
			()->assertThrows(GlobalException.class,()->dao.Registration(u2))
			);
}

@Test

public void testpassword() {
	
	UserDao dao=new UserDaoImpl();
	
	assertEquals(-1,dao.changePassword(1, "gani321", "gana123"));
	
	
}

@Test
@Disabled
public void testroom() throws GlobalException {
	
	AdminDao dao=new AdminDaoImpl();
	Room r1=new Room();
	r1.setRoomId(5);
	r1.setRoomName("heballa");
	r1.setRoomType("Non Ac");
	
	Room r2=new Room();
	r2.setRoomId(104);
	r2.setRoomName("seshadri");
	r2.setRoomType("AC");
	
	assertAll(
	()->assertEquals(1,dao.CreateRoom(r1)),
	()->assertThrows(GlobalException.class,()->dao.CreateRoom(r2))
			);
	
	
	
}
}
