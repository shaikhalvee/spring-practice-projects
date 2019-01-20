package com.practice.jpa.springbootjpahibgrdl.resources;

import com.practice.jpa.springbootjpahibgrdl.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.practice.jpa.springbootjpahibgrdl.repository.IUsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersResources {

	/*
	as per spring 5, I don't need to autowire this. because spring
	automatically auto wires it using the constructor value
	*/
	private IUsersRepository usersRepository;

	@Autowired
	public UsersResources(IUsersRepository usersRepository) {

		this.usersRepository = usersRepository;
	}

	@GetMapping("/all")
	public @ResponseBody
	List<Users> getAll() {
		return usersRepository.findAll();
	}

	@GetMapping("/{name}")
	public @ResponseBody
	List<Users> getUsers(@PathVariable("name") final String name) {

		/*
		* Optional is used, So if findByName doesn't find any name, it does not
		* become null. i.e. If returns null then we can manipulate the outcome
		* from null to an empty list.
		*/
		Optional<List<Users>> listOptional  = usersRepository.findByName(name);

		/*
		* listOptional will find by the name and if not found,
		* will return an empty list.
		*/
		List<Users> users = listOptional.orElse(new ArrayList<>());

		/*
		* this does like above, if list present then make a new list
		*
		if (listOptional.isPresent()) {
			List<Users> users1 = listOptional.get();
		}
		*/

		/*
		* Or make it throw an exception.
		*
		List<Users> usersList = listOptional.orElseThrow(() -> new RuntimeException("No users found"));
		 */

		return users;
	}


	@GetMapping("/id/{id}")
	public Optional<Users> getId(@PathVariable("id") final Integer id) {
		return usersRepository.findById(id);
	}


	@GetMapping("/update/{id}/{name}")
	public Users update(@PathVariable("id") final Integer id,
	                    @PathVariable("name") final String name) {

		Optional<Users> users = getId(id);
		Users user = users.orElse(new Users());
		user.setName(name);

		return usersRepository.save(user);
	}
}
