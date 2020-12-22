package code.microsystem.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.spi.CurrentSessionContext;

import code.microsystem.Connection.DAO;
import code.microsystem.Entity.Application;
import code.microsystem.Entity.PaymentD;
import code.microsystem.Entity.User;

public class UserService {

		public static boolean saveData(User u)
		{
			Transaction transaction = null;
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				transaction = session.beginTransaction();
				session.save(u);
				transaction.commit();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}

		public static User viewUser(String email)
		{
			User u = new User();
			Transaction tx = null;
			try {
							Session s = DAO.getSessionfactory().openSession();
							tx = s.beginTransaction();
							String SQL_QUERY   = "from User as u where u.email=:email";
							Query q = s.createQuery(SQL_QUERY, User.class);
							q.setParameter("email", email).uniqueResult();
							List<User> list = q.list();
							if(list!=null&&list.size() > 0)
							{
								for(User user:list)
								{
									u.setTest(user.getTest());
									u.setId(user.getId());
									u.setName(user.getName());
									u.setEmail(user.getEmail());
									u.setCity(user.getCity());
									u.setAddress(user.getAddress());
									u.setMobile(user.getMobile());
								}
							}else
							{
								return u;
							}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return u;
		}
		

		public static boolean paymentUser(PaymentD p) {
			Transaction transaction = null;
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				transaction = session.beginTransaction();
				session.save(p);
				transaction.commit();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}

		public static User loginUser(String email, String password) {
			Transaction transaction = null;
			User user = new User();
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				transaction = session.beginTransaction();
				String SQL_QUERY   = "from User as u where u.email=:email and u.password=:password";
				Query q = session.createQuery(SQL_QUERY, User.class);
				q.setParameter("email", email);
				q.setParameter("password", password);
				//q.setParameter("id", user.getId());
				List<User> list = q.list();
				if((list!=null)&&(list.size()>0))
				{
					user.setLogin(true);
					user.setEmail(email);
					//user.setId(id);
					return user;
				}
				else
				{
					user.setLogin(false);
					return user;
				}
			
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			return user;
		}
		public static User changePro(String email)
		{
			User u = new User();
			Transaction tx = null;
			try {
							Session s = DAO.getSessionfactory().openSession();
							tx = s.beginTransaction();
							String SQL_QUERY   = "from User as u where u.email=:email";
							Query q = s.createQuery(SQL_QUERY, User.class);
							q.setParameter("email", email).uniqueResult();
							List<User> list = q.list();
							if((list!=null)&&(list.size()>0))
							{
								for(User user:list) {
									u.setId(user.getId());
									u.setTest(user.getTest());
									u.setName(user.getName());
									u.setDob(user.getDob());
									u.setAge(user.getAge());
									u.setAadhar(user.getAadhar());
									u.setAddress(user.getAddress());
									u.setMobile(user.getMobile());
									u.setEmail(user.getEmail());
									u.setGender(user.getGender());
									u.setPassword(user.getPassword());
									u.setCity(user.getCity());
									u.setState(user.getState());
									u.setZip(user.getZip());
								}
								//System.out.println("data get");
							}
							else
							{
								System.out.println("data notget");
								return u;
							}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return u;
		}

		public static boolean updateProfle(User u) {
			Transaction tx = null;
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				tx = session.beginTransaction();
				session.update(u);
				tx.commit();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}

		public static Application viewApplication(String email)
		{
			Application a1 = new Application();
			Transaction tx = null;
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				tx = session.beginTransaction();
				String SQL_QUERY   = "from Application as u where u.email=:email";
				Query q = session.createQuery(SQL_QUERY, Application.class);
				q.setParameter("email", email);
				List<Application> list = q.list();
				if((list!=null)&&(list.size()>0))
				{                                                                      
					for(Application ap:list) {
						a1.setId(ap.getId());
						a1.setTest(ap.getTest());
						a1.setName(ap.getName());
						a1.setEmail(ap.getEmail());
						a1.setStatus(ap.getStatus());
					}
					return  a1;
				}
				tx.commit();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return a1;
			
		}

		public static User checkPassword(String email) {
			Transaction transaction = null;
			System.out.println("Done");
			User user = new User();
			//int id = 0;
			try
			{
				Session session = DAO.getSessionfactory().openSession();
				transaction = session.beginTransaction();
				String SQL_QUERY   = "from User as u where u.email=:email";
				Query q = session.createQuery(SQL_QUERY, User.class);
				q.setParameter("email", email);
				List list = q.list();
				if((list!=null)&&(list.size()>0))
				{
					user.setLogin(true);
					user.setEmail(email);
					return user;
				}
				else
				{
					user.setLogin(false);
					return user;
				}
			
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			return user;
		}
}