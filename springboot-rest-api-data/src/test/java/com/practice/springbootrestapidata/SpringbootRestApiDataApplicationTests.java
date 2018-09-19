package com.practice.springbootrestapidata;

import com.practice.springbootrestapidata.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRestApiDataApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void persistenceWorks() {
		assertThat(bookRepository.findAll(), not(Matchers.emptyIterable()));
	}

}
