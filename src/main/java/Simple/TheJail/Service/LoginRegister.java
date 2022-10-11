package Simple.TheJail.Service;

import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.User;

public interface LoginRegister {
	public void Registration() throws GlobalException;
	public void Login() throws GlobalException;
	

}
