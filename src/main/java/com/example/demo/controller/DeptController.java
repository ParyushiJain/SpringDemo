package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.deptService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class DeptController {
	@Autowired
	private deptService deptservice;
	
	private final Logger LOGGER=LoggerFactory.getLogger( DeptController.class);
	
	@PostMapping("/depts")
	public Department saveDept(@Valid @RequestBody Department dept) {
		LOGGER.info("happens");
		return deptservice.saveDept(dept);
	}
	@GetMapping("/depts")
	public List<Department> fetchdept(){
		return deptservice.fetchdept();
	}
	@GetMapping("/depts/{id}")
	public Department fetchById(@PathVariable("id") Long did) throws Exception {
		return deptservice.fetchById(did);
	}
	@DeleteMapping("/depts/{id}")
	public String delById(@PathVariable("id") Long did) {
		deptservice.delById(did);
		return "successfully deleted";
	}
	@PutMapping("/depts/{id}")
	public Department updateDept(@PathVariable("id") Long did,@RequestBody Department dept) {
		return deptservice.updateDept(did,dept);
	}
	@GetMapping("/depts/name/{name}")
	public Department fetchByName(@PathVariable("name") String name) {
		return deptservice.fetchByName(name);
	}
}
