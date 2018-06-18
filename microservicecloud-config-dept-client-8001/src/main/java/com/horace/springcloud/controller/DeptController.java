package com.horace.springcloud.controller;

import java.util.List;

import org.apache.http.client.params.ClientPNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.horace.springcloud.entities.Dept;
import com.horace.springcloud.service.DeptService;

import ch.qos.logback.core.net.server.Client;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {

		return service.add(dept);

	}

	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {

		return service.get(id);

	}


	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {

		return service.list();

	}
	
	
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object discovery() {

		List<String> list = client.getServices();
		
		System.out.println("**********"+list);
		return this.client;

	}
}
