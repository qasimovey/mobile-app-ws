package org.qasimovey.shared.dto;
import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Id;
	
	@NotNull(message = "Adi teyin olunmayib")
	private String FirstName;
	
	@NotNull(message = "Soyadi  teyin olunmayib")
	private String LastName;
	
	@NotNull(message = "Email xanasi bos ola bilmez")
	@Email(message = "Email formati duzgun deyil")
	@Size(min = 1)
	private String Email;
	

	
	
}
