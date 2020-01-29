package org.qasimovey.service;

import java.util.List;

import org.qasimovey.shared.dto.*;
public interface EmployeeServiceI {
	 EmployeeDTO createEmployee(EmployeeDTO u);
	 void removeEmployee(long id);
	 EmployeeDTO getEmployee(long id);
	 List<EmployeeDTO> getAllEmployee();
	 EmployeeDTO updateEmployee(long id,EmployeeDTO u);
}
