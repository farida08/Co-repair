package fr.isika.cdi8.projet3isika.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.isika.cdi8.projet3isika.MyApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MyApp.class })

public class TestGestionUtilisateur {
	@Test
	public void test1() {
		System.out.println("ok test");
	}
}
