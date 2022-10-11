package Simple.TheJail.Service;

import Simple.TheJail.Exception.GlobalException;

public interface AdminDashboard {

	public void Dashboard() throws GlobalException;
	public void ViewRooms();
	public void ViewUsers();
	public void CreateRoom() throws GlobalException;
	public void AllotRoom();
	public void AddDueAmount();
	public void PayDueAmount();
	public void DeleteUser();
	public void UserInRoom();
	public void ViewUserProfile();

}
