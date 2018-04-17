package de.hwrberlin.FriendsForFun;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Status;

public class PersistenceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		PersistenceManager.IS_IN_TEST = true;
		
	}
	
	@Test
	public void test() {
		
		Nutzer nutzer = new Nutzer("abc@xyz.de", "ABC1", new Date(110, 11, 21), 'w', "start-123", new Status("aktiv"));
		
		List<Nutzer> nutzerlist = PersistenceManager.getPersistenceManager().getNutzer();
		
		assertTrue(nutzerlist.size() == 1);
		
		for (Nutzer n : nutzerlist) {
			System.out.println(n.toString());
		}
		
	}


}
