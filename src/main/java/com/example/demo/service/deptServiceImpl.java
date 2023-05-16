package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DeptNotFoundException;
import com.example.demo.repo.deptRepo;

@Service
public class deptServiceImpl implements deptService{
	@Autowired
    private deptRepo deptrepo;
	@Override
	public Department saveDept(Department dept) {
		// TODO Auto-generated method stub
		return deptrepo.save(dept);
	}
	@Override
	public List<Department> fetchdept() {
		// TODO Auto-generated method stub
		return deptrepo.findAll();
	}
	@Override
	public Department fetchById(Long did) throws Exception{
		// TODO Auto-generated method stub
		Optional<Department> dept= deptrepo.findById(did);
		if(dept.isPresent()==false) {
			throw new DeptNotFoundException("Dept Not fOUND YA");
		}
		else return dept.get();
	}
	@Override
	public void delById(Long did) {
		// TODO Auto-generated method stub
		deptrepo.deleteById(did);
		
	}
	@Override
	public Department updateDept(Long did, Department dept) {
		// TODO Auto-generated method stub
		Department deptDb=deptrepo.findById(did).get();
		if(deptDb.getDa().isEmpty()==false) deptDb.setDa(dept.getDa());
		if(deptDb.getDc().isEmpty()==false) deptDb.setDc(dept.getDc());
		if(deptDb.getDn().isEmpty()==false) deptDb.setDn(dept.getDn());
		return deptrepo.save(deptDb);
	}
	@Override
	public Department fetchByName(String name) {
		// TODO Auto-generated method stub
		return deptrepo.findByDnIgnoreCase(name);
	}

}
