package com.practice.springbootrestapidata.callback;

import com.practice.springbootrestapidata.domain.Book;
import com.practice.springbootrestapidata.domain.WebsiteUser;
import com.practice.springbootrestapidata.repository.BookRepository;
import com.practice.springbootrestapidata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSetup implements ApplicationRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;


	@Override
	public void run(ApplicationArguments args) throws Exception {
		//bookRepository.save(Book.builder().title("Subtle art of not giving a fuck").isbn("1221").build());
		//bookRepository.save(Book.builder().title("Harry Potter").isbn("324332").build());

		userRepository .save(WebsiteUser.builder().name("MyName").email("myemail@mail.com").build());
		userRepository .save(WebsiteUser.builder().name("MyName1").email("myemail1@mail.com").build());

	}
}
