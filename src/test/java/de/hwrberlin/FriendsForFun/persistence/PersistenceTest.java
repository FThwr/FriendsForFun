package de.hwrberlin.FriendsForFun.persistence;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Status;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

public class PersistenceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		PersistenceManager.IS_IN_TEST = true;
		
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
		PersistenceManager.IS_IN_TEST = false;
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
		new Nutzer("abc@xyz.de", "ABC1", new Date(110, 11, 21), 'w', "start-123", new Status("aktiv"));
		
		List<Nutzer> nutzerlist = new NutzerManager().getNutzer();
		
		assertTrue(nutzerlist.size() == 1);
		
		for (Nutzer n : nutzerlist) {
			System.out.println(n.toString());
		}
		
	}


}
