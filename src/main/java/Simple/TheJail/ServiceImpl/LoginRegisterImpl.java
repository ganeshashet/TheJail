package Simple.TheJail.ServiceImpl;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import Simple.TheJail.App;
import Simple.TheJail.Dao.TheJailDao;
import Simple.TheJail.DaoImpl.TheJailDaoImpl;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.User;
import Simple.TheJail.Service.AdminDashboard;
import Simple.TheJail.Service.LoginRegister;
import Simple.TheJail.Service.UserDashboard;

public class LoginRegisterImpl implements LoginRegister{
	// Using Logger to Dsiplaying thye output
		static Logger log=Logger.getLogger(App.class);
		// This Dao will communicating with DaoImplementation
		static TheJailDao dao=new TheJailDaoImpl();
		// Scanner will help Reading Input By Users
		static Scanner sc=new Scanner(System.in);
	@Override
	public void Registration() throws GlobalException {
		// TODO Auto-generated method stub
		
		log.info("----------welcome to register----------");
		User u1=new User();
		log.info("Enter User Name :");
		String name=sc.next();
		log.info("Enter User Password :");
		String password=sc.next();
		log.info("Enter Phone Number :");
		String phone=sc.next();
		log.info("Enter User  Address :");
		String address=sc.next();
		// setting all the user details value
		u1.setUserName(name);
		u1.setUserPassword(password);
		u1.setUserPhone(phone);
		u1.setUserAddress(address);
		u1.setUserRole("student");
		u1.setUserFee(0);
		u1.setUserRoom(null);
		//checking the name,password,phonenumber will valid or not
		/*if(Pattern.matches("[a-zA-Z]{4,}",name)&&Pattern.matches("[0-9]{10}",phone)&&Pattern.matches("[a-zA-Z0-9@#]{5,}",password))
		{
			//inserting the values after above condition Satisfied
			int status=dao.Registration(u1);
			if(status==1)
			{
				log.info("Register Sucessfully");
			}
			
		}
		else
		{
			throw new GlobalException("inavlid  data");
		}
		*/
		ValidatorFactory vf=Validation.buildDefaultValidatorFactory();
		Validator valid=vf.getValidator();
		
	Set<ConstraintViolation<User>> violation=valid.validate(u1);
	
	if(violation.size()>0) {
		for(ConstraintViolation<User> vio:violation)
			log.info(vio.getMessage());
	}	
	else {
		int status=dao.Registration(u1);	
		if(status==1) {
			log.info("registration success");
		}
	}
		
		
	}

	@Override
	public void Login() throws GlobalException {
		// TODO Auto-generated method stub
		log.info("----------welcome to login----------");
		log.info("enter UserName");
		String Uname=sc.next();
		log.info("enter User Password");
		String Upassword=sc.next();
		User u1=dao.Login(Uname,Upassword);
		UserDashboard ud1=new UserDashboardImpl();
		AdminDashboard ad1=new AdminDashboardImpl();
		if(u1!=null)
		{
			log.info("hey"+u1.getUserName()+"login.Sucessfull");
			if(u1.getUserRole().equals("student"))
			{
				ud1.Dashboard(u1.getUserId());
			}
			else
				if(u1.getUserRole().equals("admin"))
				{
					ad1.Dashboard();
				}
		}
		
		
	}



	
}
