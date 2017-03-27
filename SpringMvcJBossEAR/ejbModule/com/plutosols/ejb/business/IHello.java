package com.plutosols.ejb.business;

import javax.ejb.Remote;

@Remote
public interface IHello {
	public String sayHello();
}