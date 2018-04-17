package de.hwrberlin.FriendsForFun;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Status;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
	
//	private static EntityManager em;
//	 
//    public static void main(String[] args) {
// 
//    	PersistenceManager pm = new PersistenceManager().getPersistenceManager();
//    	
////        EntityManagerFactory emf = pm.
//        		
//        		//Persistence
//                //.createEntityManagerFactory("default");
////        em = emf.createEntityManager();
// 
//    	pm.create(new Nutzer("abc@xyz.de", "abc123", new Date(110, 11, 21), 'w', "start-123"));
//    	
////        createEmployee();
// 
//    }
// 
//    private static void createEmployee() {
//        em.getTransaction().begin();
//        Nutzer emp = new Nutzer("abc@xyz.de", "abc123", new Date(110, 11, 21), 'w', "start-123", new Status("aktiv"));
//        em.persist(emp);
//        em.getTransaction().commit();
//    }

	   public static void main( String[ ] args ) 
	   {
//	      EntityManagerFactory emfactory = Persistence.
//	      createEntityManagerFactory( "default" );
//	      EntityManager entitymanager = emfactory.
//	      createEntityManager( );
//	      entitymanager.getTransaction( ).begin( );

	      Nutzer employee = new Nutzer("abc@xyz.de", "abc123", new Date(110, 11, 21), 'w', "start-123");
//	      employee.setId(123);
//	      entitymanager.persist( employee );
//	      entitymanager.getTransaction( ).commit( );
//
//	      entitymanager.close( );
//	      emfactory.close( );
	   }
	
}
