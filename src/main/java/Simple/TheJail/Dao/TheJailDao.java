package Simple.TheJail.Dao;

import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.User;

public interface TheJailDao {

	public int Registration(User u1) throws GlobalException;

	public User Login(String uname, String upassword)throws GlobalException;

	

}
