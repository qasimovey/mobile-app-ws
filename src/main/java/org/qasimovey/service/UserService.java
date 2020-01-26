package org.qasimovey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.qasimovey.AppExceptionHandling.FavoriteException;
import org.qasimovey.model.User;
import org.qasimovey.repository.Baza;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.qasimovey.shared.dto.*;

@Service(value = "UserServiceOLD")
public class UserService implements UserServiceI {
	
	//private Map<String,UserDTO> baza;
	
	private Baza baza ;
	private Utils utils;
	
	
	public UserService( @Autowired Utils u, @Autowired Baza baza) {
		utils=u;
		this.baza=baza;
	}
	
	@Override
	public UserDTO createUser(UserDTO dto) {	
		dto.setId(utils.generateID());
		
		User u= new User();
		BeanUtils.copyProperties(dto, u);
		baza.createUser(u);
		return dto;
	}

	@Override
	public void removeUser(String id) {
		baza.removeUser(id);		
	}

	@Override
	public UserDTO getUser(String id) {
		User u=baza.getUser(id);
		if(u!=null) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(u, dto);
			return dto;
		}
		else throw new FavoriteException(id+" - li User tapilmadi");
		
	}

	@Override
	public List<UserDTO> getAllUser() throws FavoriteException{
		List<User> liste=baza.getAllUser();
		if(liste.size()==0) 
			throw new FavoriteException("Bazada User yoxdur");
		
		List<UserDTO> liste_dto=new ArrayList<>();
		for (User u : liste) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(u, dto);
			liste_dto.add(dto);
		}
		return liste_dto;
	}

	@Override
	public UserDTO updateUser(String id,UserDTO dto) throws FavoriteException{
		

		if(!baza.IsExist(id)) throw new FavoriteException("Teyin edilen ID li user yoxdur");

		User uu=baza.getUser(id);

		if(dto.getEmail()!=null && !dto.getEmail().equals(uu.getEmail()) )
			uu.setEmail(dto.getEmail());
		if(dto.getFirstName()!=null && !dto.getFirstName().equals(uu.getFirstName()) )
			uu.setFirstName(dto.getFirstName());
		if(dto.getLastName()!=null && !dto.getLastName().equals(uu.getLastName()) )
			uu.setLastName(dto.getLastName());

		baza.updateUser(id, uu);
		BeanUtils.copyProperties(uu, dto);
	return dto;
}
	
}
