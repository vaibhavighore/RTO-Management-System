package code.microsystem.Connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import code.microsystem.Entity.Admin;
import code.microsystem.Entity.Application;
import code.microsystem.Entity.PaymentD;
import code.microsystem.Entity.User;

public class DAO {
	public static SessionFactory sessionfactory = null;
	public static SessionFactory getSessionfactory() {
		if(sessionfactory == null)
		{
		try {
			Configuration cfg = new Configuration();
			Properties setting = new Properties();
			setting.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			setting.put(Environment.URL,"jdbc:mysql://localhost:3306/rtodb?useSSL=false");
			setting.put(Environment.USER,"root");
			setting.put(Environment.PASS,"root");
			
			setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			setting.put(Environment.SHOW_SQL,"true");
			setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
			setting.put(Environment.HBM2DDL_AUTO,"update");
			cfg.setProperties(setting);
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(PaymentD.class);
			cfg.addAnnotatedClass(Application.class);
			cfg.addAnnotatedClass(Admin.class);
			ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().
					applySettings(cfg.getProperties()).build();
			System.out.println("Hibernate Java Config serviceRegistry created");
			
			sessionfactory=cfg.buildSessionFactory(serviceregistry);
			return sessionfactory;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		return sessionfactory;
	}
}
