package posjavamavemhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {

		try {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("Pos-java-mavem-hibernate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	
	public static EntityManager getEntityManeger() {
		return factory.createEntityManager();/*Prove a parte de persistência*/
	}
	
	public static Object getPrimaryKey(Object entity) {//retorna a primary key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
