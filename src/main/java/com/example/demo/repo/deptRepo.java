package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface deptRepo extends JpaRepository<Department,Long> {
	public Department findByDn(String dn);
	public Department findByDnIgnoreCase(String dn);
}
