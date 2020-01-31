package org.qasimovey;

import org.qasimovey.model.entity.Employee;
import org.qasimovey.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MobileAppWsApplication {
	@Autowired
	EmployeeRepository employeeRepository ;

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}
/*
	@PostConstruct
	public void DBInit(){
		List<Employee> siyahi= Arrays.asList(new Employee(1,"Elchin","Gasimov","test@com.ui"),
						new Employee(2,"AAAA","AAAA","TEST@AAA.COM"));
		employeeRepository.saveAll(siyahi);
		employeeRepository.flush();
	}
  */
	@Bean
	public CommandLineRunner run(EmployeeRepository employeeRepository) throws Exception {
		return (String[] args) -> {
			Employee user1 = new Employee(1, "ADMIN", "ADMIN", "ADMIN@test.com", 9999999, new Date(System.currentTimeMillis()),90);
			employeeRepository.save(user1);
			employeeRepository.flush();
			//employeeRepository.findAll().forEach(user -> System.out.println(user);
		};
	}


}

