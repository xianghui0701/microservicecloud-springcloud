package com.horace.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horace.springcloud.dao.DeptDao;
import com.horace.springcloud.entities.Dept;
import com.horace.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptdao;
	
	@Override
	public boolean add(Dept dept) {
		
		return deptdao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		
		return deptdao.findById(id);
	}

	@Override
	public List<Dept> list() {
		
		return deptdao.findAll();
	}

}
