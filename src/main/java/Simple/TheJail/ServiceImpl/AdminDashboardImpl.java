package Simple.TheJail.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import Simple.TheJail.App;
import Simple.TheJail.Dao.AdminDao;
import Simple.TheJail.DaoImpl.AdminDaoImpl;
import Simple.TheJail.DaoImpl.UserDaoImpl;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;
import Simple.TheJail.Service.AdminDashboard;

public class AdminDashboardImpl implements AdminDashboard{
	static Logger log=Logger.getLogger(UserDashboardImpl.class);
	static Scanner sc=new Scanner(System.in);
	static AdminDashboard service=new AdminDashboardImpl();
	static AdminDao dao=new AdminDaoImpl();

	@Override
	public void Dashboard() throws GlobalException  {
		// TODO Auto-generated method stub
		log.info("\t\t---------------------------welcome to Admin Dashboard--------------------");
		int op=0;
		while(op<10)
		{
			log.info("\n\t Press 1 for View Room\n\t Press 2 for View User\n\t Press 3 for Create Room\n\t Press 4 for Allot Room\n\t Press 5 for Add Due Amount\n\t Press 6 Pay Due Amount\n\t Press 7 for Delete User\n\t Press 8 for User InRoom \n\t Press 9 for View UserProfile");
			op=sc.nextInt();
			switch(op)
			{
				case 1->service.ViewRooms();
				case 2->service.ViewUsers();
				case 3->service.CreateRoom();
				case 4->service.AllotRoom();
				case 5->service.AddDueAmount();
				case 6->service.PayDueAmount();
				case 7->service.DeleteUser();
				case 8->service.ViewUserProfile();
				case 9->service.UserInRoom();
				default->System.exit(0);
			}
		}
		
	}

	@Override
	public void ViewRooms() {
		List<Room> roomList=dao.ViewRooms();
		for(Room r:roomList) {
			log.info(r);
		}
	}

	@Override
	public void ViewUsers() {
		List<User> userList=dao.ViewUsers();
		for(User u1:userList)
			log.info(u1);
	}

	@Override
	public void CreateRoom() throws GlobalException {
		log.info("Enter room Id");
		int rId=sc.nextInt();
		log.info("Enter roomName");
		String rName=sc.next();
		log.info("Enter roomType");
		String rType=sc.nextLine();
		
		Room r1=new Room();
		r1.setRoomId(rId);
		r1.setRoomName(rName);
		r1.setRoomType(rType);
		
		int st=dao.CreateRoom(r1);
		if(st==1) {
			log.info("Room added successfully");
		}
	}

	@Override
	public void AllotRoom() {
		log.info("Enter userId");
		int uId=sc.nextInt();
		log.info("Enter roomId");
		int rId=sc.nextInt();
		int st=dao.AllotRoom(uId, rId);
		if(st==1) {
			log.info("room alloted!...");
		}
	}

	@Override
	public void AddDueAmount() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter amount to add");
		int amount=sc.nextInt();
		int st=dao.AddDueAmount(uid, amount);
		if(st==1) {
			log.info("fee updated");
		}
	}

	@Override
	public void PayDueAmount() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter amount to add");
		int amount=sc.nextInt();
		int st=dao.PayDueAmount(uid, amount);
		if(st==1) {
			log.info("fee updated");
		}
	}

	@Override
	public void DeleteUser() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		int st=dao.DeleteUser(uid);
	if(st==1) {
		log.info("deleted!....");
	}
		
	}

	@Override
	public void UserInRoom() {
		log.info("Enter room Id");
		int rid=sc.nextInt();
		List<User> userList=dao.UserInRoom(rid);
		for(User u1:userList)
			log.info(u1);
		
	}

	@Override
	public void ViewUserProfile() {
		log.info("Enter userid");
		int uid=sc.nextInt();
		User u1=dao.ViewUserProfile(uid);
		log.info(u1);
	
		
	}
	

}
