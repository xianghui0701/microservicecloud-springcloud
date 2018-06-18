package com.horace.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.horace.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService>{

	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public Dept findById(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息,Consumer客户端提供的降级信息，刺客Provider已经关闭")
						.setDb_source("no this database in MySql");
			}

			@Override
			public List<Dept> findAll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}