package Simple.TheJail.Dao;

import Simple.TheJail.Model.User;

public interface UserDao {
	public User viewProfile(int Uid);
	public int viewDueAmount(int Uid);
	public User viewRoom(int Uid);
	public int UpdatePhone(int Uid,String Uphone);
	public int changePassword(int Uid,String oldpwd,String newPwd);
	
	

}
