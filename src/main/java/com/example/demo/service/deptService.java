package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface deptService {

	public Department saveDept(Department dept);

	public List<Department> fetchdept();

	public Department fetchById(Long did) throws Exception;

	public void delById(Long did);

	public Department updateDept(Long did, Department dept);

	public Department fetchByName(String name);

}
