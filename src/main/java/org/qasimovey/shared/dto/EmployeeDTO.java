package org.qasimovey.shared.dto;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private long Id;

	@NotNull(message = "FirstName teyin olunmayib")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull(message = "LastName  teyin olunmayib")
	@Column(name = "LAST_NAME")
	private String lastName;


	@NotNull(message = "Email xanasi bos ola bilmez")
	@Email(message = "Email formati duzgun deyil")
	@Size(min = 1)
	@Column(name="EMAILL")
	private String email;

	@Column(name = "SALARY")
	private long Salary;

	@Column(name = "HIRE_DATE")
	private Date Hiring_date;

	@Column(name = "DEPARTMENT_ID")
	private int Department_id;

	
}
