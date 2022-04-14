package com.test.cvtheque;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cvtheque.cvtheque.ihm.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cvthequeApplicationTests {

	@Autowired
	Hello testhello;
	
	@Test
	public void contextLoads() {
	
		if(!"hello".equals("testhello")) {
			
			fail("Ce n'est pas bon");
		}
	}

}
