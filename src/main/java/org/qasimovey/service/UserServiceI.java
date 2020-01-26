package org.qasimovey.service;

import java.util.List;

import org.qasimovey.model.User;
import org.qasimovey.shared.dto.*;
public interface UserServiceI {
	public UserDTO createUser(UserDTO u);
	public void removeUser(String id);
	public UserDTO getUser(String id);
	public List<UserDTO> getAllUser();
	public UserDTO updateUser(String id,UserDTO u);
}
