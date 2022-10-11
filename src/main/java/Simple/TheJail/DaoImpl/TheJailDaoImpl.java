package Simple.TheJail.DaoImpl;

import org.hibernate.Session;

import Simple.TheJail.Config.HibernateUtil;
import Simple.TheJail.Dao.TheJailDao;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.User;

public class TheJailDaoImpl implements TheJailDao {

	@Override
	public int Registration(User u1) throws GlobalException {
		// TODO Auto-generated method stub
		//Auto Closeble Session
		try(Session ses=HibernateUtil.getSession())
		{
			ses.beginTransaction();
			//getting username for check available of user name or not
			String Username=u1.getUserName();
			User u2=null;
			u2=(User)ses.createQuery("from User where UserName=:Username").setParameter("Username", Username).uniqueResult();
			if(u2==null)
			{
				//saving the user
				ses.save(u1);
				ses.getTransaction().commit();
				return 1;
			}
			else
			{
				throw new GlobalException("User name is already taken ");
			}
		}
	}

	@Override
	public User Login(String uname, String upassword) throws GlobalException {
		// TODO Auto-generated method stub
		//auto closeable code
		try(Session ses=HibernateUtil.getSession())
		{
			ses.beginTransaction();
			//checking the username is in the database or table
			User u2=(User)ses.createQuery("from User where UserName=:Username").setParameter("Username", uname).uniqueResult();
			if(u2!=null)
			{
				if(u2.getUserPassword().equals(upassword))
				{
					return u2;
				}
				else
				{
					throw new GlobalException("Worng Username or password ");
				}
			}
			else
			{
				throw new GlobalException("User not Found");
			}
		}
	}

}
