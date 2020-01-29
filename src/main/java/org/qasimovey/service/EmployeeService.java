package org.qasimovey.service;

import java.util.ArrayList;
import java.util.List;

import org.qasimovey.AppExceptionHandling.FavoriteException;
import org.qasimovey.model.entity.Employee;
import org.qasimovey.repository.EmployeeRepository;
import org.qasimovey.shared.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "EmployeeServiceOLD")
public class EmployeeService implements EmployeeServiceI {

	private EmployeeRepository employeeRepository;
	private Utils utils;
	
	
	public EmployeeService(@Autowired Utils u, @Autowired EmployeeRepository employeeRepository) {
		utils=u;
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		dto.setId(utils.generateID());

		Employee u= new Employee();
		BeanUtils.copyProperties(dto, u);
		employeeRepository.save(u);
		return dto;
	}

	@Override
	public void removeEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeDTO getEmployee(long id) {
		Employee u=employeeRepository.findById(id).get();
		if(u!=null) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(u, dto);
			return dto;
		}
		else throw new FavoriteException(id+" - li Employee tapilmadi");
		
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() throws FavoriteException{
		List<Employee> liste=employeeRepository.findAll();
		if(liste.size()==0) 
			throw new FavoriteException("Bazada Employee yoxdur");
		
		List<EmployeeDTO> liste_dto=new ArrayList<>();
	/*	for (User u : liste) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(u, dto);
			liste_dto.add(dto);
		} */
		
		liste.stream().forEach(i->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(i, dto);
			liste_dto.add(dto);
		});
		
		return liste_dto;
	}

	@Override
	public EmployeeDTO updateEmployee(long id,EmployeeDTO dto) throws FavoriteException{
		

		if(!employeeRepository.existsById(id)) throw new FavoriteException("Teyin edilen ID li Employee yoxdur");

		Employee uu=employeeRepository.findById(id).get();

		if(dto.getEmail()!=null && !dto.getEmail().equals(uu.getEmail()) )
			uu.setEmail(dto.getEmail());
		if(dto.getFirstName()!=null && !dto.getFirstName().equals(uu.getFirstName()) )
			uu.setFirstName(dto.getFirstName());
		if(dto.getLastName()!=null && !dto.getLastName().equals(uu.getLastName()) )
			uu.setLastName(dto.getLastName());

		employeeRepository.save(uu);
		BeanUtils.copyProperties(uu, dto);
	return dto;
}
	
}
