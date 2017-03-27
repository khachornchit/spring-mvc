package com.plutosols.ejb.businesslogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.plutosols.ejb.business.IHello;

@Stateless
@LocalBean
public class HelloBean implements IHello {

	public HelloBean() {
	}

	@Override
	public String sayHello() {
		return "Hello Boss, Welcome to EJB";
	}
}