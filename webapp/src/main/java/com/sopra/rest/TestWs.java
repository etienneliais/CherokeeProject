package com.sopra.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sopra.dao.TestDao;

@Path("test")
public class TestWs {
	@EJB
	TestDao dao;

	@GET
	public String test() {
		return "hello " + dao.test();
	}
}
