package Simple.TheJail.DaoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import Simple.TheJail.Config.HibernateUtil;
import Simple.TheJail.Dao.AdminDao;
import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Model.Room;
import Simple.TheJail.Model.User;
import Simple.TheJail.Service.UserDashboard;

public class AdminDaoImpl implements AdminDao {
	static Logger log=Logger.getLogger(UserDashboard.class); 
	{
		log.info("----------welcome to Admin DashBoard----------");
	}
	@Override
	public List<Room> ViewRooms() {
		try(Session ses=HibernateUtil.getSession())
		{
			List<Room> list=ses.createQuery("from Room").getResultList();
		    return list;	
		}

	}
	@Override
	public List<User> ViewUsers() {
		try(Session ses=HibernateUtil.getSession())
		{
			List<User> list=ses.createQuery("from User where userRole='student'").getResultList();
			return list;
		}
	}
	@Override
	public int CreateRoom(Room r1) throws GlobalException {
		String RoomName=r1.getRoomName();
		try(Session ses=HibernateUtil.getSession())
		{
			ses.beginTransaction();
			Room r2=(Room)ses.createQuery("from Room where roomName=:RoomName").setParameter("RoomName",RoomName).uniqueResult();
			if(r2!=null)
			{
				throw new GlobalException("Room Name is already Existed");
			}
			else
			{
				ses.save(r1);
				ses.getTransaction().commit();
				return 1;
			}
		}
	}
	@Override
	public int AllotRoom(int uId, int rId) {
		try(Session ses=HibernateUtil.getSession()){
			ses.beginTransaction();
			int status=ses.createQuery("update User set userRoom_roomId=:roomid where userId=:userid")
					.setParameter("roomid", rId).setParameter("userid", uId)
					.executeUpdate();
			ses.getTransaction().commit();
			return status;
		}
	}
	@Override
	public int AddDueAmount(int uId, int amount) {
		try(Session ses=HibernateUtil.getSession())
		{
			ses.beginTransaction();
			User u2=ses.get(User.class, uId);
			
			int dueAmount=u2.getUserFee();
			dueAmount+=amount;
			int status=ses.createQuery("update User set userFee=:amount where userId=:uid")
					.setParameter("amount", dueAmount).setParameter("uid", uId).executeUpdate();
			
			ses.getTransaction().commit();
			return status;
		}
	}
	@Override
	public int PayDueAmount(int uId, int amount) {
		try(Session ses=HibernateUtil.getSession()){
			ses.beginTransaction();
			
			User u2=ses.get(User.class, uId);
			int dueAmount=u2.getUserFee();
			dueAmount-=amount;
			int status=ses.createQuery("update User set userFee=:amount where userId=:uid")
					.setParameter("amount", dueAmount).setParameter("uid", uId).executeUpdate();
			
			ses.getTransaction().commit();
			return status;
				
		}
	}
	@Override
	public int DeleteUser(int uId) {
        try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			int status=ses.createQuery("delete from User where userId=:uid").setParameter("uid",uId).executeUpdate();
			ses.getTransaction().commit();
			return status;
		}
	}
	@Override
	public List<User> UserInRoom(int rId) {
try(Session ses=HibernateUtil.getSession()){
			
			List<User> userList=ses.createQuery("from User where userRoom_roomId=:rid").setParameter("rid",rId).getResultList();
			return userList;
		}
	}
	@Override
	public User ViewUserProfile(int uId) {
try(Session ses=HibernateUtil.getSession()){
			
			User u2=ses.get(User.class, uId);
			return u2;
		}
	}

}
