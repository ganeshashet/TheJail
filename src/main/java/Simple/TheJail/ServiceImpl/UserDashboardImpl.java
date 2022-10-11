package Simple.TheJail.ServiceImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import Simple.TheJail.Dao.UserDao;
import Simple.TheJail.DaoImpl.UserDaoImpl;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;
import Simple.TheJail.Service.UserDashboard;

public class UserDashboardImpl implements UserDashboard {
	static Logger log=Logger.getLogger(UserDashboardImpl.class);

	
	static int userId=0;
	static Scanner sc=new Scanner(System.in);
	static UserDashboard ud1=new UserDashboardImpl();
	static UserDao dao=new UserDaoImpl();
	@Override
	public void Dashboard(int Uid) throws GlobalException{
	
		log.info("----------welcome to User DashBoard----------");
		userId=Uid;
		int op=0;
		while(op<6) {
		log.info("\n\tPress 1 for View Profile\n\tPress 2 for View Due Ammount\n\tPress 3 for View Room\n\tPress 4 for Change Phone Number\n\tPress 5 for Change Password\n\t ");
         op=sc.nextInt();		
		
		switch(op) {
		
		case 1->ud1.viewProfile();
		
		case 2->ud1.viewDueAmount();
		
		case 3->ud1.viewRoom();
		
		case 4->ud1.updatePhone();
		
		case 5->ud1.changePassword();
		
		}
		}
		
	
	}
	@Override
	public void viewProfile() {
		//calling dao viewprofile
				User u1=dao.viewProfile(userId);
				log.info(u1);
				
	}
	@Override
	public void viewDueAmount() {
		// TODO Auto-generated method stub
		int amount=dao.viewDueAmount(userId);
		log.info("Hello User your due amount is "+amount);
	}
	@Override
	public void viewRoom() {
		// TODO Auto-generated method stub
		User u1=dao.viewProfile(userId);
		Room r1=u1.getUserRoom();
		log.info("your room number is : "+r1.getRoomId()+" name is : "+r1.getRoomName()+" and it is: "+r1.getRoomType()+" room");
	}
	@Override
	public void updatePhone() throws GlobalException {
		// TODO Auto-generated method stub
		log.info("Enter new Phone number");
		String phone=sc.next();
		int status=dao.UpdatePhone(userId, phone);
		if(status==1) {
			log.info("phone number updated!...");
		}
		else {
			throw new GlobalException("something went wrong");
		}
	}
	@Override
	public void changePassword() throws GlobalException {
		// TODO Auto-generated method stub
		log.info("Enter current password");
		String oldpwd=sc.next();
		log.info("Enter New password");
		String newpwd=sc.next();
		int status=dao.changePassword(userId, oldpwd, newpwd);
		if(status==1) {
			log.info("password updated!...");
		}
		else {
			throw new GlobalException("something went wrong");
		}
	}

}
