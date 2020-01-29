package org.qasimovey.controller;

import java.util.List;

import javax.validation.Valid;

import org.qasimovey.AppExceptionHandling.FavoriteException;
import org.qasimovey.service.EmployeeServiceI;
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
import org.springframework.web.bind.annotation.RestController;
import org.qasimovey.shared.dto.*;

@RestController
@RequestMapping(value = "api/employees") //http://localhost:7227/
public class EmployeeController {
	
	//private Map<String,User> map;
	
	@Autowired
	@Qualifier("EmployeeServiceOLD")
	private EmployeeServiceI employeeService;
	//private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	//Get Users

	@GetMapping() //http://localhost:7227/users/?page=10&limit=20
	public List<EmployeeDTO> getAllUsers() {
		return employeeService.getAllEmployee();
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
	
	//Get Employee
	@GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String id) {

		EmployeeDTO u=employeeService.getEmployee(Integer.parseInt(id));
		return new ResponseEntity<EmployeeDTO>(u,HttpStatus.NOT_FOUND);
	}
		
	//Create Employee
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_XML_VALUE,
						   MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeDTO> createEmployee( @Valid @RequestBody EmployeeDTO u) {

		EmployeeDTO ru=employeeService.createEmployee(u);
		return new ResponseEntity<EmployeeDTO>(ru,HttpStatus.OK);
	}
	
	
	//Delete Employee
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
		employeeService.removeEmployee(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//Update Employee
	@PutMapping("/{id}") //UPDATE necessary field ler qeyd olunur
	public ResponseEntity<EmployeeDTO> updateEmployee( @PathVariable String id,/*@Valid*/ @RequestBody EmployeeDTO u) {
		EmployeeDTO uu=employeeService.updateEmployee(Integer.parseInt(id),u);
	return new ResponseEntity<>(uu,HttpStatus.OK);
	}
	
}
