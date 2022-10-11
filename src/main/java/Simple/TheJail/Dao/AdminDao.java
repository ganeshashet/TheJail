package Simple.TheJail.Dao;

import java.util.List;

import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;

public interface AdminDao {
	public List<Room> ViewRooms();
	public List<User> ViewUsers();
	public int CreateRoom(Room r1) throws GlobalException;
	public int AllotRoom(int uId,int rId);
	public int AddDueAmount(int uId,int amount);
	public int PayDueAmount(int uId,int amount);
	public int DeleteUser(int uId);
	public List<User> UserInRoom(int rId);
	public User ViewUserProfile(int uId);

}
