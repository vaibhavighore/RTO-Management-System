package code.microsystem.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import code.microsystem.Connection.DAO;
import code.microsystem.Entity.Admin;
import code.microsystem.Entity.Application;
import code.microsystem.Entity.User;


public class AdminService {

	public static List<User> viewAllDetails()
	{
		List<User> user = null;
		Transaction transaction = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			transaction = session.beginTransaction();
			user = session.createQuery("From User").getResultList();
			
			transaction.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
		
	}
	public static User getStatus(int id)
	{
		User a = new User();
		Transaction transaction = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			transaction = session.beginTransaction();
			a = (User)session.get(User.class, id);
			session.saveOrUpdate(a);
			transaction.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}
	
	public static boolean changeStatus(Application ap) {
		Transaction transaction = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			transaction = session.beginTransaction();
			session.save(ap);
			transaction.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public static boolean userDelete(User u) {

		Transaction transaction = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			transaction = session.beginTransaction();
			u = (User)session.get(User.class, u.getId());
			session.delete(u);
			transaction.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public static boolean applicationDelete(User u) {
		Transaction transaction = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			transaction = session.beginTransaction();
			u = (User)session.get(User.class, u.getId());
			session.delete(u);
			transaction.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public static boolean loginAdmin(String email, String password) {
		Admin admin = null;
		Transaction tx = null;
		try
		{
			Session session = DAO.getSessionfactory().openSession();
			tx = session.beginTransaction();
			String SQL_QUERY   = "from Admin as u where u.email=:email and u.password=:password";
			Query q = session.createQuery(SQL_QUERY, Admin.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			//q.setParameter("id", user.getId());
			List list = q.list();
			if((list!=null)&&(list.size()>0))
			{
				
				return true;
			}
			else
			{
				
				return false;
			}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
}
}
