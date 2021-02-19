package m�tier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		public static final SessionFactory sessionFactory;
		static {
		try {
		// Création de la SessionFactory à partir de hibernate.cfg.xml

		sessionFactory = new
		Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
		System.err.println("Initial SessionFactory creation failed." + ex);
		throw new ExceptionInInitializerError(ex);
		}
		}
		public static SessionFactory getSessionFactory() {
		return sessionFactory;
		}
		}

