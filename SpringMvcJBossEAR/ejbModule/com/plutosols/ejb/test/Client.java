package com.plutosols.ejb.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.plutosols.ejb.business.IHello;

public class Client {

	public static void main(String[] args) {
		IHello bean = doLookup();
		System.out.println(bean.sayHello());
	}

	private static IHello doLookup() {
		Context context = null;
		IHello bean = null;
		try {
			context = getInitialContext();
			bean = (IHello) context.lookup(LOOKUP_STRING);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static final String LOOKUP_STRING = "HelloBean/remote";

	private static final String PROVIDER_URL = "jnp://localhost:1099";

	private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";

	private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";

	private static Context initialContext;

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
			prop.put(Context.PROVIDER_URL, PROVIDER_URL);
			initialContext = new InitialContext(prop);
		}
		return initialContext;
	}
}
