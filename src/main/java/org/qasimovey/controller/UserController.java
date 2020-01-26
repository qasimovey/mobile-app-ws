package org.qasimovey.controller;

import java.util.List;

import javax.validation.Valid;

import org.qasimovey.AppExceptionHandling.FavoriteException;
import org.qasimovey.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.qasimovey.shared.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping(value = "api/users") //http://localhost:7227/users
public class UserController {
	
	//private Map<String,User> map;
	
	@Autowired
	@Qualifier("UserServiceOLD")
	private UserServiceI userService;
	//private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	//Get Users
	@GetMapping() //http://localhost:7227/users/?page=10&limit=20
	public List<UserDTO> getAllUsers() {
		return userService.getAllUser();
	}
	
	/*//Get Users
	@GetMapping() //http://localhost:7227/users/?page=10&limit=20
	public String getUsers(@RequestParam(value = "page",defaultValue = "1")int page ,
							@RequestParam(value="limit")int limit) {
		return "getUsers is called " + "returned "+page+" between "+limit;
	}
	*/
	
	
	
	@GetMapping(value = {"/exception1"})
	public String getException1() {
		//log.debug("DEBUG MEQSEDLI ERROR : getException1() ");
		String s=null;
		s.length();
		return "everything is nice";
	}
	
	@GetMapping(value = {"/exception2"})
	public String getException2() {
		if(true)throw new FavoriteException("Biznes terefde xeta bas verdi");
		return "everything is nice";
	}
	
	//Get User
	@GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDTO> getUser(@PathVariable String id) {

		UserDTO u=userService.getUser(id);
		//MultiValueMap<String, String> map =new LinkedMultiValueMap<>();
		//map.add("acar", "deyer");
		return new ResponseEntity<UserDTO>(u,HttpStatus.NOT_FOUND);
	}
		
	//Create User
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDTO> createUser( @Valid @RequestBody UserDTO u) {
		
		UserDTO ru=userService.createUser(u);		
		return new ResponseEntity<UserDTO>(ru,HttpStatus.OK);
	}
	
	
	//Delete User
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		userService.removeUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//Update User
	@PutMapping("/{id}") //UPDATE necessary field ler qeyd olunur
	public ResponseEntity<UserDTO> updateUser( @PathVariable String id,/*@Valid*/ @RequestBody UserDTO u) {
		UserDTO uu=userService.updateUser(id,u);
	return new ResponseEntity<>(uu,HttpStatus.OK);
	}
	
}
