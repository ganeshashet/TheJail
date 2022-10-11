package Simple.TheJail.DaoImpl;

import java.util.Scanner;



import org.apache.log4j.Logger;
import org.hibernate.Session;

import Simple.TheJail.Config.HibernateUtil;
import Simple.TheJail.Dao.UserDao;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.User;
import Simple.TheJail.Service.UserDashboard;
import Simple.TheJail.ServiceImpl.UserDashboardImpl;

public class UserDaoImpl  implements UserDao {
	static Logger log=Logger.getLogger(UserDashboard.class);
	
	@Override
	// view user profile
	public User viewProfile(int Uid) {
		// TODO Auto-generated method stub
        try(Session ses=HibernateUtil.getSession()){
			
			User u1=null;
			u1=ses.get(User.class, Uid);
			return u1;
			
		}
	}
	@Override
	public int viewDueAmount(int Uid) {
		// TODO Auto-generated method stub
      try(Session ses=HibernateUtil.getSession()){
	
			
			int userFee=(int)ses.createQuery("select userFee from User where userId=:uId").setParameter("uId", Uid).uniqueResult();
			return userFee;
			
		}
	}
	@Override
	public User viewRoom(int Uid) {
		// TODO Auto-generated method stub
         try(Session ses=HibernateUtil.getSession()){
			
			User u1=null;
			u1=ses.get(User.class, Uid);
			return u1;
			
		}
	}
	@Override
	public int UpdatePhone(int Uid, String Uphone) {
		// TODO Auto-generated method stub
          try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			
			int st=ses.createQuery("update User set userPhone=:phone where userId=:uId").setParameter("phone", Uphone).setParameter("uId", Uid).executeUpdate();
			
			ses.getTransaction().commit();
			return st;
			
		} 
	}
	@Override
	public int changePassword(int Uid, String oldpwd, String newPwd) {
		// TODO Auto-generated method stub
try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			
			String s1=(String)ses.createQuery("select userPassword from User where userId=:uid").setParameter("uid", Uid).uniqueResult();
			
			if(s1.equals(oldpwd)) {
				
				int status=ses.createQuery("update User set userPassword=:newpwd where userId=:uid").setParameter("newpwd", newPwd).setParameter("uid", Uid).executeUpdate();
				
				ses.getTransaction().commit();
				return status;
			}
			else {
				return -1;
			}
		}
	}

}
