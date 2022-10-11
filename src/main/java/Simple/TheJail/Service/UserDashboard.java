package Simple.TheJail.Service;

import org.apache.log4j.Logger;

import Simple.TheJail.Exception.GlobalException;

public interface UserDashboard {

	public void Dashboard(int userId) throws GlobalException;

	public void viewProfile();

	public void viewDueAmount();

	public void viewRoom();

	public void updatePhone() throws GlobalException;

	public void changePassword() throws GlobalException;


}
