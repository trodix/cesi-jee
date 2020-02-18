package com.cesi.jee;

import com.cesi.jee.entities.Category;
import com.cesi.jee.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class JeeApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CategoryRepository employeeRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCategoryCreation() {
		// given
		Category c = new Category();
		entityManager.persist(c);
		entityManager.flush();
		// when
		Category found = employeeRepository.findByName(c.getName());
		// then
		Assert.assertEquals(c.getName(), found.getName());
	}

}
