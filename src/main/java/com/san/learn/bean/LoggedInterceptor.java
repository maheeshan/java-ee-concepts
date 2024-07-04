package com.san.learn.bean;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.san.learn.annotation.Logged;

import lombok.SneakyThrows;

@Interceptor
@Logged
@Priority(Interceptor.Priority.APPLICATION)
public class LoggedInterceptor {

	@Inject
	private Logger logger;

	private String user = "SAN";

	@AroundInvoke
	@SneakyThrows
	public Object logMethodCall(InvocationContext invocationContext) {
		logger.log(Level.INFO, "User {0} invoked {1} method at {2}",
				new Object[] {user, invocationContext.getMethod().getName(), LocalDate.now()});
		return invocationContext.proceed();
	}
}
