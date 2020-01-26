package org.qasimovey.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Id;
	
	@NotNull(message = "FirstName teyin olunmayib")
	private String firstName;
	
	@NotNull(message = "LastName  teyin olunmayib")
	private String lastName;
	
	@NotNull(message = "Email xanasi bos ola bilmez")
	@Email(message = "Email formati duzgun deyil")
	@Size(min = 1)
	private String email;
	

	
	
}
