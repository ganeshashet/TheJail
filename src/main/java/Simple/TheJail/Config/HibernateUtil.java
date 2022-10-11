package Simple.TheJail.Config;

import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;

public class HibernateUtil {
	private static SessionFactory sesFact;
	public static SessionFactory getSessionFactory()
	
	{
		if(sesFact==null)
		{
			try
			{
				// Configuration to HQL
			Configuration conf=new Configuration();
			Properties pro=new Properties();
			// Connecting database Driver to project TheJail
			pro.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			//Connecting URL with Database
			pro.put(Environment.URL,"jdbc:mysql://localhost:3306/TheJail");
			//User Name
			pro.put(Environment.USER,"root");
			// Password
			pro.put(Environment.PASS,"Ganesha@123");
			// Connecting auto Dialect 
			pro.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			//Create or update the table using Hdm2ddl 
			pro.put(Environment.HBM2DDL_AUTO,"update");
			conf.setProperties(pro);
			// Adding User Table to database TheJail
			conf.addAnnotatedClass(User.class);
			// Adding Room Table to database TheJail
			conf.addAnnotatedClass(Room.class);
			sesFact=conf.buildSessionFactory();
}
			
			catch(Exception e) {
				
			}
		}
		return sesFact;
	}
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}