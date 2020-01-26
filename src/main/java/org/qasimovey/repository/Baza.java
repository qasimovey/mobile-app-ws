package org.qasimovey.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.qasimovey.model.User;
import org.qasimovey.shared.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class Baza {
	private Map<String,User> baza;
	
	public Baza (){
		baza=new HashMap<String, User>();
	}
	
	public void createUser(User u) {
		baza.put(u.getId(), u);
	};
	public void removeUser(String id) {
		baza.remove(id);
	};
	public User getUser(String id) {
		return baza.containsKey(id)?baza.get(id):null;
	};
	public List<User> getAllUser(){
		List<User> liste=new ArrayList<>();
		for(Map. Entry<String, User>  entry : baza.entrySet()) {
			liste.add(entry.getValue());
		}
		return liste;
		
	};
	public User updateUser(String id,User u) {
		return baza.put(id, u);		
	};
	
	public boolean IsExist(String key) {
		return baza.containsKey(key);
	}
}
